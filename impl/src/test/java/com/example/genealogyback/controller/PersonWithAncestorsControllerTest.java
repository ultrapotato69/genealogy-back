package com.example.genealogyback.controller;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.utils.ResourceUtils;
import com.example.genealogyback.utils.annotations.SqlClearDb;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SqlClearDb
@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
public class PersonWithAncestorsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResourceUtils resourceUtils;

    @Nested
    class GetPersonWithAncestors {

        @Test
        @Sql({"/sql/person/insert-persons.sql", "/sql/parents/add-parents.sql"})
        void ok() throws Exception {
            String personCreate = resourceUtils.getJsonFromResources(BasePersonDto.class,
                    "json/parents/response/person-with-ancestors-tree.json");

            mockMvc.perform(get("/person/{id}/ancestors/", "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(personCreate));
        }

        @Test
        void noSuchPerson() throws Exception {
            String readById = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/no-such-person.json");


            mockMvc.perform(get("/person/{id}/ancestors/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().json(readById));
        }
    }
}
