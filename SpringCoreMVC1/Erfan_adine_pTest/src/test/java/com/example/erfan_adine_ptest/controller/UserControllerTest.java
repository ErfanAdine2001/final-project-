package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ActiveProfiles("test")
@WebMvcTest( controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserController userController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }

    @Test
    void create() throws Exception {

        UserInDto userInDto = new UserInDto();
        userInDto.setId(1L);
        userInDto.setEmail("erfan@gmail.com");
        userInDto.setPassword("123Aa");
        userInDto.setFirstName("erfan");
        userInDto.setLastName("adine");


        mvc.perform(MockMvcRequestBuilders
                        .post("/users/create")
                        .content(asJsonString(userInDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    ObjectMapper objectMapper = new ObjectMapper();

    protected String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void findAllByFNameAndLNameAndEmailAndPassword() {
    }

    @Test
    void findAllByFNameAndLName() {
    }

    @Test
    void showAllOrders() {
    }

    @Test
    void showAllSubServices() {
    }

    @Test
    void selectSubService() {
    }

    @Test
    void seeTheSuggestionsThatAreACCEPTED() {
    }

    @Test
    void selectWorkerWithSuggestionIdAndWaitingForWorkerSelectedU() {
    }

    @Test
    void addComment() {
    }

    @Test
    void findAllOrder() {
    }

    @Test
    void loadAmount() {
    }



}