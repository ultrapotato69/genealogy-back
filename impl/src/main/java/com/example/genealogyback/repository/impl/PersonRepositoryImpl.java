package com.example.genealogyback.repository.impl;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.PersonWithRelativesDto;
import com.example.genealogyback.dto.RelativeDto;
import com.example.genealogyback.dto.ResponsePersonDto;
import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.repository.PersonRepository;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.example.genealogyback.jooq.tables.Parents.PARENTS;
import static com.example.genealogyback.jooq.tables.Persons.PERSONS;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final DSLContext dsl;

    public PersonRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public ResponsePersonDto insert(BasePersonDto personDto) {
        return dsl.insertInto(PERSONS)
                .set(dsl.newRecord(PERSONS, personDto))
                .returning()
                .fetchOptional()
                .orElseThrow(() -> new DataAccessException("Error inserting entity: [%s].".formatted(personDto)))
                .into(ResponsePersonDto.class);
    }

    @Override
    public PersonWithRelativesDto readById(UUID id) {
        return dsl.selectFrom(PERSONS)
                .where(PERSONS.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> new NoSuchResourceException("Person with [%s] is not found."
                        .formatted(id)))
                .into(PersonWithRelativesDto.class);
    }

    @Override
    public ResponsePersonDto update(UUID id, BasePersonDto basePersonDto) {
        return dsl.update(PERSONS)
                .set(PERSONS.FIRST_NAME, basePersonDto.getFirstName())
                .set(PERSONS.SURNAME, basePersonDto.getSurname())
                .set(PERSONS.GENDER, basePersonDto.getGender())
                .set(PERSONS.SPOUSE_ID, basePersonDto.getSpouseId())
                .set(PERSONS.MAIDEN_NAME, basePersonDto.getMaidenName())
                .set(PERSONS.BIRTH_DATE, basePersonDto.getBirthDate())
                .set(PERSONS.DEATH_DATE, basePersonDto.getDeathDate())
                .set(PERSONS.BIO, basePersonDto.getBio())
                .set(PERSONS.AVATAR, basePersonDto.getAvatar())
                .where(PERSONS.ID.eq(id))
                .returning()
                .fetchOptional()
                .orElseThrow(() -> new NoSuchResourceException("Person with [%s] is not found."
                        .formatted(id)))
                .into(ResponsePersonDto.class);
    }

    @Override
    public void deleteById(UUID id) {
        boolean isDeleted = dsl.deleteFrom(PERSONS)
                .where(PERSONS.ID.eq(id))
                .execute() > 0;

        if (!isDeleted) {
            throw new NoSuchResourceException("Person with [%s] is not found.".formatted(id));
        }
    }

    @Override
    public RelativeDto findSpouseById(UUID id) {
        return selectRelative()
                .where(PERSONS.SPOUSE_ID.eq(id))
                .fetchOneInto(RelativeDto.class);
    }


    @Override
    public List<RelativeDto> findChildrenById(UUID id) {
        return selectRelative()
                .join(PARENTS)
                .on(PARENTS.CHILD_ID.eq(PERSONS.ID))
                .where(PARENTS.PARENT_ID.eq(id))
                .fetchInto(RelativeDto.class);
    }

    @Override
    public List<RelativeDto> findParentsById(UUID id) {
        return selectRelative()
                .join(PARENTS)
                .on(PARENTS.PARENT_ID.eq(PERSONS.ID))
                .where(PARENTS.CHILD_ID.eq(id))
                .fetchInto(RelativeDto.class);
    }

    private SelectJoinStep<Record> selectRelative() {
        return dsl.select(List.of(PERSONS.ID, PERSONS.FIRST_NAME, PERSONS.SURNAME, PERSONS.GENDER))
                .from(PERSONS);
    }
}
