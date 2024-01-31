package com.example.genealogyback.controller;

import com.example.genealogyback.dto.ParentsDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@SqlClearDb
@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
public class ParentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResourceUtils resourceUtils;

    @Nested
    class AddParent {

        @Test
        @Sql("/sql/person/insert-persons.sql")
        void created() throws Exception {
            String addParent = resourceUtils.getJsonFromResources(ParentsDto.class,
                    "json/parents/add-parent.json");

            mockMvc.perform(post("/person/{id}/parents/", "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(addParent))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(addParent));
        }

        @Test
        void noSuchEntity() throws Exception {
            String addParent = resourceUtils.getJsonFromResources(ParentsDto.class,
                    "json/parents/add-parent.json");

            mockMvc.perform(post("/person/{id}/parents/", "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(addParent))
                    .andDo(print())
                    .andExpect(status().isNotFound());
        }

        @Test
        @Sql({"/sql/person/insert-persons.sql", "/sql/parents/add-parent.sql"})
        void violateUniqueParentType() throws Exception {
            String addParent = resourceUtils.getJsonFromResources(ParentsDto.class,
                    "json/parents/add-parent.json");
            String error = resourceUtils.getJsonFromResources(Object.class,
                    "json/parents/response/error/violate-unique-parent-type.json");

            mockMvc.perform(post("/person/{id}/parents/", "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(addParent))
                    .andDo(print())
                    .andExpect(status().isUnprocessableEntity())
                    .andExpect(content().json(error));
        }
    }

    @Nested
    class Delete {

        @Test
        @Sql({"/sql/person/insert-persons.sql", "/sql/parents/add-parent.sql"})
        void ok() throws Exception {
            mockMvc.perform(delete("/person/{id}/parents/{parent_id}/",
                            "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", "52abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isOk());

        }
        @Test
        @Sql({"/sql/person/insert-persons.sql",})
        void noSuchParent() throws Exception {
            mockMvc.perform(delete("/person/{id}/parents/{parent_id}/",
                            "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", "52abcd2b-8b9c-4af9-88f7-0bc180cf74b4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$[0].detail").value("Parent with childId [42abcd2b-8b9c-4af9-88f7-0bc180cf74b4] " +
                            "and parentId [52abcd2b-8b9c-4af9-88f7-0bc180cf74b4] is not found."));;

        }

    }
}
