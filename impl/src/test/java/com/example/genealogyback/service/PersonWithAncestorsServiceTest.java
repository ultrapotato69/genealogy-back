package com.example.genealogyback.service;

import com.example.genealogyback.dto.PersonWithAncestorsDto;
import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;
import com.example.genealogyback.utils.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonWithAncestorsServiceTest {

    @Autowired
    private PersonWithAncestorsService personWithAncestorsService;
    @Autowired
    private ResourceUtils resourceUtils;

    @Test
    void buildTree() {

        List<PersonWithAncestorsProjection> personList = resourceUtils.getObjectFromResources(
                "json/parents/response/person-with-ancestors-flat-list.json",
                new TypeReference<>() {
                });
        PersonWithAncestorsDto expectedPerson = resourceUtils.getObjectFromResources(
                "json/parents/response/person-with-ancestors-tree.json", PersonWithAncestorsDto.class);

        PersonWithAncestorsDto person = personWithAncestorsService.buildTree(personList);

        assertThat(person).isEqualTo(expectedPerson);
    }
}