package com.example.genealogyback.repository.impl;

import com.example.genealogyback.dto.ParentsDto;
import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.repository.ParentsRepository;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.example.genealogyback.jooq.tables.Parents.PARENTS;

@Repository
public class ParentsRepositoryImpl implements ParentsRepository {
    private final DSLContext dsl;

    public ParentsRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public ParentsDto insert(UUID id, ParentsDto parentsDto) {
        return dsl.insertInto(PARENTS)
                .set(PARENTS.CHILD_ID, id)
                .set(PARENTS.PARENT_ID, parentsDto.getId())
                .set(PARENTS.PARENT_TYPE, parentsDto.getParentType())
                .returning(PARENTS.PARENT_ID, PARENTS.PARENT_TYPE)
                .fetchOptional()
                .map(parentsRecord -> {
                    ParentsDto parent = new ParentsDto();
                    parent.setId(parentsRecord.getParentId());
                    parent.setParentType(parentsRecord.getParentType());
                    return parent;
                })
                .orElseThrow(() -> new DataAccessException("Error inserting entity: [%s] with id [%s]."
                        .formatted(parentsDto, id)));
    }

    @Override
    public void delete(UUID id, UUID parentId) {
        boolean isDeleted = dsl.deleteFrom(PARENTS)
                .where(PARENTS.CHILD_ID.eq(id))
                .and(PARENTS.PARENT_ID.eq(parentId))
                .execute() > 0;

        if (!isDeleted) {
            throw new NoSuchResourceException("Parent with childId [%s] and parentId [%s] is not found."
                    .formatted(id, parentId));
        }
    }
}
