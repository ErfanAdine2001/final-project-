package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ActiveProfiles("test")
@WebMvcTest( controllers = UserController.class)
class UserControllerTest extends RestControllerTest{

//    @MockBean
//    private UserController userController;
//
//    @Autowired
//    private MockMvc mvc;
////
//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(userController).isNotNull();
//    }

    @Test
    void create() throws Exception {

        UserInDto userInDto = new UserInDto();
//        userInDto.setId(1L);
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
    void findAllByFNameAndLNameAndEmailAndPassword() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void findAllByFNameAndLName() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void showAllOrders() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void showAllSubServices() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void selectSubService() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void seeTheSuggestionsThatAreACCEPTED() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void selectWorkerWithSuggestionIdAndWaitingForWorkerSelectedU() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addComment() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAllOrder() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void loadAmount() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/users/loadAmount/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}