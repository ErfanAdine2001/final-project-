package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ActiveProfiles("test")
@WebMvcTest(controllers = WorkerController.class)
//@SpringJUnitConfig(.class)
class WorkerControllerTest extends RestControllerTest{

    @Test
    void create() throws Exception {
        WorkerInDto workerInDto = new WorkerInDto();
        workerInDto.setEmail("erfan@gmail.com");
        mvc.perform(post("/workers/create").contentType(MediaType.APPLICATION_JSON).content(toJson(workerInDto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.code").value(201))
                .andExpect(jsonPath("$.errors").isEmpty());
    }


    @Test
    void findAllByFNameAndLNameAndEmailAndPassword() {
    }

    @Test
    void findAllByFNameAndLName() {
    }

    @Test
    void findSuggestionForMainOrder() {
    }

    @Test
    void sendSuggestionForMainOrder() {
    }

    @Test
    void loadCommentsByOrderId() {
    }

    @Test
    void findAllOrder() {
    }


    //************************

}