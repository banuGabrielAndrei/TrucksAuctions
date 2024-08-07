package com.TrucksAuctions.registerLoginUsers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.TrucksAuctions.controllers.UsersController;
import com.TrucksAuctions.services.UsersService;

@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UsersService usersService;

    @InjectMocks
    private UsersController usersController;

    @Test
    @WithMockUser
    public void testRegisterForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().
                name("register"))
                .andExpect(MockMvcResultMatchers.model().
                attributeExists("user"));
    }

    @Test
    @WithMockUser
    public void testLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login-page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().
                    name("login-page"));
    }
}
