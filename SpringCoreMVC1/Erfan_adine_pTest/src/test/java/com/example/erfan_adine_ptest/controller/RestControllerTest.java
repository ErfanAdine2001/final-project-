package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.service.RequestService;
import com.example.erfan_adine_ptest.service.UserService;
import com.example.erfan_adine_ptest.service.WorkerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




    public abstract class RestControllerTest {
        @Autowired
        protected MockMvc mvc;

        @MockBean
        protected UserService userService;

        @MockBean
        protected RequestService requestService;

        @MockBean
        protected WorkerService workerService;


        ObjectMapper objectMapper = new ObjectMapper();

        protected String toJson(Object obj) throws JsonProcessingException {
            return objectMapper.writeValueAsString(obj);
        }

        protected <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
            return objectMapper.readValue(json , clazz);
        }
    }


