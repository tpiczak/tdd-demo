package com.example.demo.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TeamNameProvider {
    private final RestTemplate restTemplate;

    public TeamNameProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTeamName(String userId) {
        return restTemplate.getForEntity("http://localhost:8080/getTeamAssignment/" + userId, TeamNameResponse.class).getBody().teamNName;
    }
}
