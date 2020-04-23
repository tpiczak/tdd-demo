package com.example.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TeamMemberControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllTeamMembers_asJSON() throws Exception {
         mockMvc.perform(get("/getAllTeamMembers"))
                .andExpect(status().isOk())
               .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"userId\": \"tpicza1\",\n" +
                        "    \"firstName\": \"Tom\",\n" +
                        "    \"lastName\": \"Piczak\",\n" +
                        "    \"team\": \"Starflake\"\n" +
                        "  },\n" +
                        "  " +
                        "{\n" +
                        "    \"userId\": \"jlowrey\",\n" +
                        "    \"firstName\": \"Jon\",\n" +
                        "    \"lastName\": \"Lowrey\",\n" +
                        "    \"team\": null\n" +
                        "  }\n" +
                        "]"));
    }
}