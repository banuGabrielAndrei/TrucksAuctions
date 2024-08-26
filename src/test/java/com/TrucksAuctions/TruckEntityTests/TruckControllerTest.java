package com.TrucksAuctions.TruckEntityTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.TrucksAuctions.controllers.TrucksController;
import com.TrucksAuctions.services.TrucksService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrucksController.class)
public class TruckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrucksService trucksService;

    @Test
    @WithMockUser
    public void testAllTrucks() throws Exception {
        mockMvc.perform(get("/trucks"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("trucks"))
                .andExpect(view().name("trucks"));
    }

    @Test
    @WithMockUser
    public void testAddTruckForm() throws Exception {
        mockMvc.perform(get("/add-trucks"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("truck"))
                .andExpect(view().name("add-trucks"));
    }
}
