package com.example.demo.web;

import com.example.demo.common.TeamMember;
import com.example.demo.service.TeamMemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = TeamMemberController.class)
class TeamMemberControllerTest {

    public static final List<TeamMember> TEAM_MEMBERS = asList(
            new TeamMember("tpicza1", "Tom", "Piczak", "Starflake"),
            new TeamMember("jlowrey", "Jon", "Lowrey", null)
    );
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TeamMemberService service;

    @BeforeEach
    void setUp() {

        when(service.getAllTeamMembers()).thenReturn(TEAM_MEMBERS);
    }

    @Test
    void shouldReturnAllTeamMembers_asJSON() throws Exception {
        mockMvc.perform(get("/getAllTeamMembers"))
                .andExpect(status().isOk())
        //        .andExpect(content().json(objectMapper.writeValueAsString(TEAM_MEMBERS)));
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