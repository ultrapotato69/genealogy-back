package com.example.genealogyback.repository.impl;

import com.example.genealogyback.dto.ParentTypeDto;
import com.example.genealogyback.repository.PersonWithAncestorsRepository;
import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;
import org.jooq.*;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.example.genealogyback.jooq.tables.Parents.PARENTS;
import static com.example.genealogyback.jooq.tables.Persons.PERSONS;
import static org.jooq.impl.DSL.*;

@Repository
public class PersonWithAncestorsRepositoryImpl implements PersonWithAncestorsRepository {
    private final DSLContext dsl;

    public PersonWithAncestorsRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<PersonWithAncestorsProjection> get(UUID id) {

        String personCte = "person_cte";
        String childId = "child_id";
        String parentId = "parent_id";
        String parentType = "parent_type";

        CommonTableExpression<Record3<UUID, UUID, ParentTypeDto>> parentTraversal =
                name(personCte).fields(childId, parentId, parentType).as(
                        select(PARENTS.CHILD_ID, PARENTS.PARENT_ID, PARENTS.PARENT_TYPE)
                                .from(PARENTS)
                                .where(PARENTS.CHILD_ID.eq(id))
                                .unionAll(
                                        select(PARENTS.CHILD_ID, PARENTS.PARENT_ID, PARENTS.PARENT_TYPE)
                                                .from(PARENTS, table(name(personCte))
                                                .where(field(name(personCte, parentId)).eq(PARENTS.CHILD_ID)))));

        Result<Record> fetch = dsl.withRecursive(parentTraversal)
                .select(prefixAliasAllFieldsBy(PERSONS, "%s"))
                .select(prefixAliasField(parentTraversal.field(childId, PARENTS.CHILD_ID.getDataType()), "%s"),
                        prefixAliasField(parentTraversal.field(parentType, PARENTS.PARENT_TYPE.getDataType()), "%s"))
                .from(PERSONS)
                .join(parentTraversal)
                .on(PERSONS.ID.eq(parentTraversal.field(parentId, UUID.class)))
                .union(
                        select(prefixAliasAllFieldsBy(PERSONS, "%s"))
                                .select(
                                        val(null, PARENTS.CHILD_ID.getDataType()).as(childId),
                                        val(null, PARENTS.PARENT_TYPE.getDataType()).as(parentType))
                                .from(PERSONS).where(PERSONS.ID.eq(id)))
                .fetch();
        return fetch
                .into(PersonWithAncestorsProjection.class);
    }

    public static List<? extends Field<?>> prefixAliasAllFieldsBy(Table<?> table, String format) {
        return table.fieldStream()
                .map(x -> x.as(format.formatted(x.getName())))
                .toList();
    }

    public static Field<?> prefixAliasField(Field<?> field, String format) {
        return field.as(format.formatted(field.getName()));
    }
}
