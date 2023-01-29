//package com.agit.account.interfaces.rest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.agit.account.application.internal.commandservices.AccountCommandService;
//import com.agit.account.application.internal.queryservices.AccountQueryService;
//import com.agit.account.domain.model.aggregates.identifiers.CreateAccountId;
//import com.agit.account.interfaces.rest.dto.CreateAccountResource;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AccountRestController.class)
//class AccountRestControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AccountCommandService accountCommandService;
//
//    @MockBean
//    private AccountQueryService accountQueryService;
//
//
//    @Test
//    @Order(1)
//    @DisplayName("accountName number and phone are abnormal")
//    void createAccount_AllAbnormal() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders
//            .post("/account")
//            .content(asJsonString(new CreateAccountResource(null, "010-9652-4489")))
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isBadRequest())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.accountName").exists());
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Phone number is abnormal")
//    void createAccount_phoneAbnormal() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders
//            .post("/account")
//            .content(asJsonString(new CreateAccountResource("mac book", "010-9652-4489")))
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isBadRequest())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists());
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("accountName is abnormal")
//    void createAccount_accountNameAbnormal() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders
//            .post("/account")
//            .content(asJsonString(new CreateAccountResource(null, "01096524489")))
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isBadRequest())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.accountName").exists());
//    }
//
//    @Test
//    @Order(4)
//    @DisplayName("CreateAccountResource is normal")
//    void createAccount_normal() throws Exception {
//
//        //given
//        CreateAccountResource createAccountResource = new CreateAccountResource("mac book", "01096524489");
//
////        when(accountCommandService.createAccount(CreateAccountCommandDTOAssembler.toCommandFromDTO(createAccountResource)))
////        .thenReturn(new CreateAccountId("1"));
//
//        //when&then
//        mockMvc.perform( MockMvcRequestBuilders
//            .post("/account")
//            .content(asJsonString(new CreateAccountResource("mac book", "01096524489")))
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isCreated());
//    }
//
//    @Test
//    @Order(5)
//    void findByCreateAccountId() {
//    }
//
//    @Test
//    @Order(6)
//    void getAllAccounts() {
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            final ObjectMapper mapper = new ObjectMapper();
//            final String jsonContent = mapper.writeValueAsString(obj);
//            return jsonContent;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}