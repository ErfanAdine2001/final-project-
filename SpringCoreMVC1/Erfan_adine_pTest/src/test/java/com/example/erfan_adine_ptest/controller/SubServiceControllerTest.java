package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.example.erfan_adine_ptest.dto.in.work.SubServiceInDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.erfan_adine_ptest.controller.UserControllerTest.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SubServiceControllerTest  extends RestControllerTest{

    @Test
    void showAllSubServices() {
    }

    @Test
    void create() throws Exception {

        List<Long> mainServiceService = new ArrayList<>();
        mainServiceService.add(1L);
        mainServiceService.add(2L);

        SubServiceInDto subServiceInDto = new SubServiceInDto();

        subServiceInDto.setMainServiceId(mainServiceService);
        subServiceInDto.setBasePrice(BigDecimal.valueOf(123));
        subServiceInDto.setName("wash car");



        mvc.perform(MockMvcRequestBuilders
                        .post("/users/create")
                        .content(asJsonString(subServiceInDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}