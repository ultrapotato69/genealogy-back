package com.example.genealogyback.repository;

import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;
import com.example.genealogyback.utils.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonWithAncestorsRepositoryTest {

    @Autowired
    private PersonWithAncestorsRepository personWithAncestorsRepository;
    @Autowired
    private ResourceUtils resourceUtils;

    @Test
    @Sql({"/sql/person/insert-persons.sql", "/sql/parents/add-parents.sql"})
    void get() {
        List<PersonWithAncestorsProjection> expected = resourceUtils.getObjectFromResources(
                "json/parents/response/person-with-ancestors-flat-list.json",
                new TypeReference<>() {
                });

        List<PersonWithAncestorsProjection> personWithAncestorsProjections =
                personWithAncestorsRepository.get(UUID.fromString("42abcd2b-8b9c-4af9-88f7-0bc180cf74b4"));


        assertThat(personWithAncestorsProjections)
                .hasSameElementsAs(expected);
    }
}