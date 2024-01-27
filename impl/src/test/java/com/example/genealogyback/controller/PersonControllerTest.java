package com.example.genealogyback.controller;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ResponsePersonDto;
import com.example.genealogyback.utils.ResourceUtils;
import com.example.genealogyback.utils.annotations.SqlClearDb;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SqlClearDb
@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResourceUtils resourceUtils;

    @Nested
    class Create {
        @Test
        void ok() throws Exception {
            String personCreate = resourceUtils.getJsonFromResources(BasePersonDto.class,
                    "json/persons/request/create-ok.json");

            mockMvc.perform(post("/person/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(personCreate))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(personCreate));
        }

        @Test
        void invalidInput() throws Exception {
            String invalidInputResponse = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/create-invalid-input.json");

            mockMvc.perform(post("/person/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{}"))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(invalidInputResponse));
        }

    }

    @Nested
    class ReadById {
        @Test
        @Sql(value = "/sql/person/insert-person.sql")
        void ok() throws Exception {
            String readById = resourceUtils.getJsonFromResources(ResponsePersonDto.class,
                    "json/persons/person-with-id.json");

            mockMvc.perform(get("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(readById));
        }

        @Test
        void noSuchPerson() throws Exception {
            String readById = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/no-such-person.json");

            mockMvc.perform(get("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().json(readById));
        }

    }

    @Nested
    class Update {
        @Test
        @Sql(value = "/sql/person/insert-person.sql")
        void ok() throws Exception {
            String personUpdate = resourceUtils.getJsonFromResources(BasePersonDto.class,
                    "json/persons/request/update-ok.json");
            String personUpdated = resourceUtils.getJsonFromResources(ResponsePersonDto.class,
                    "json/persons/response/update-ok.json");

            mockMvc.perform(put("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(personUpdate))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(personUpdated));
        }

        @Test
        @Sql(value = "/sql/person/insert-person.sql")
        void invalidInput() throws Exception {
            String invalidInputResponse = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/create-invalid-input.json");

            mockMvc.perform(put("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{}"))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(invalidInputResponse));
        }

        @Test
        void noSuchPerson() throws Exception {

            String personUpdate = resourceUtils.getJsonFromResources(BasePersonDto.class,
                    "json/persons/request/update-ok.json");
            String readById = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/no-such-person.json");

            mockMvc.perform(put("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(personUpdate))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().json(readById));
        }
    }

    @Nested
    class Delete {
        @Test
        @Sql(value = "/sql/person/insert-person.sql")
        void ok() throws Exception {
            String readById = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/no-such-person.json");

            mockMvc.perform(delete("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isOk());

            mockMvc.perform(delete("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().json(readById));
        }


        @Test
        void noSuchPerson() throws Exception {
            String readById = resourceUtils.getJsonFromResources(Object.class,
                    "json/persons/response/error/no-such-person.json");

            mockMvc.perform(delete("/person/{id}/", "12abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().json(readById));
        }

    }
}
