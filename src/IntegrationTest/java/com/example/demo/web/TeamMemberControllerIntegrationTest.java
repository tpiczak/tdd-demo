package com.example.demo.web;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TeamMemberControllerIntegrationTest {

    WireMockServer wms = new WireMockServer(8081);
    @Autowired
    private MockMvc mockMvc;

}