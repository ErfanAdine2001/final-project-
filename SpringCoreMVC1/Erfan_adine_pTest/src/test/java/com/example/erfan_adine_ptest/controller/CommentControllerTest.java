package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.erfan_adine_ptest.controller.UserControllerTest.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CommentControllerTest extends RestControllerTest{

    @Test
    void create() throws Exception {
        AdminInDto adminInDto = new AdminInDto();
        adminInDto.setEmail("erfan@gmail.com");
        adminInDto.setPassword("123Aa");
        adminInDto.setFirstName("erfan");
        adminInDto.setLastName("adine");


        mvc.perform(MockMvcRequestBuilders
                        .post("/manager/create")
                        .content(asJsonString(adminInDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void findAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}