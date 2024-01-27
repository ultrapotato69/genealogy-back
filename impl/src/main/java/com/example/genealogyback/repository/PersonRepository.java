package com.example.genealogyback.repository;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ResponsePersonDto;
import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.jooq.tables.daos.PersonsDao;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.example.genealogyback.jooq.tables.Persons.PERSONS;

@Repository
public class PersonRepository extends PersonsDao {
    private final DSLContext dsl;

    public PersonRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public ResponsePersonDto insert(BasePersonDto personDto) {
        return dsl.insertInto(PERSONS)
                .set(dsl.newRecord(PERSONS, personDto))
                .returning()
                .fetchOptional()
                .orElseThrow(() -> new DataAccessException("Error inserting entity: [%s].".formatted(personDto)))
                .into(ResponsePersonDto.class);
    }

    public ResponsePersonDto readById(UUID id) {
        return dsl.selectFrom(PERSONS)
                .where(PERSONS.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> new NoSuchResourceException("Person with [%s] is not found."
                        .formatted(id)))
                .into(ResponsePersonDto.class);
    }
}
