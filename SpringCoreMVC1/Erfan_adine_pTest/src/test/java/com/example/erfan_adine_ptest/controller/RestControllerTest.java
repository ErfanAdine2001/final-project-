package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.service.*;
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
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public abstract class RestControllerTest {
    @Autowired
    protected MockMvc mvc;

//    @Autowired
////    protected WebApplicationContext webApplicationContext;

    @MockBean
    protected UserService userService;

    @MockBean
    protected RequestService requestService;

    @MockBean
    protected WorkerService workerService;

    @MockBean
    protected SubService_Service service_service;

    @MockBean
    protected SuggestionService suggestionService;

    @MockBean
    protected TransactionService transactionService;

    @MockBean
    protected AdminService adminService;

    @MockBean
    protected MainService_Service mainServiceService;

    @MockBean
    protected MainOrderService mainOrderService;


    @MockBean
    protected ExperteService service;

    @MockBean
    protected CommentService commentService;


    ObjectMapper objectMapper = new ObjectMapper();

    protected String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }
}


