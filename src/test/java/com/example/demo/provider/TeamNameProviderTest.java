package com.example.demo.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamNameProviderTest {

    @Mock
    RestTemplate restTemplate;

    TeamNameProvider subject;

    @BeforeEach
    void setUp() {
        when(restTemplate.getForEntity("http://localhost:8080/getTeamAssignment/jlowrey", TeamNameResponse.class))
                .thenReturn(new ResponseEntity<TeamNameResponse>(new TeamNameResponse("Sentinel"), HttpStatus.OK));
        subject = new TeamNameProvider(restTemplate);
    }

    @Test
    void shouldReturnTeamName_forGivenUserId() {
        String teamName = subject.getTeamName("jlowrey");
        assertNotNull(teamName);
        assertEquals("Sentinel", teamName);
    }
}