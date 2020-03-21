package com.example.demo.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TeamNameProvider {
    private final RestTemplate restTemplate;

    @Value("${base.url:}")
    private String baseUrl = "";

    public TeamNameProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTeamName(String userId) {
        return restTemplate.getForEntity(baseUrl + "/getTeamAssignment/" + userId, TeamNameResponse.class).getBody().teamNName;
    }
}
