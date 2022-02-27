package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.erfan_adine_ptest.controller.UserControllerTest.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AdminControllerTest extends RestControllerTest {

    @Autowired
    protected MockMvc mvc;

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
    void searchWorkers() {
    }

    @Test
    void searchAllWorkerByFNameAndLName() {
    }

    @Test
    void searchUsers() {
    }

    @Test
    void searchAllUserByFNameAndLName() {
    }

    @Test
    void addMainService() {
    }

    @Test
    void appointmentOfASpecialistToTheService() {
    }

    @Test
    void addNewWorkerToMainService() {
    }

    @Test
    void isExistWork() {
    }

    // username password

}