package com.example.demo.provider;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamNameResponse {
    public final String teamNName;

    @JsonCreator
    public TeamNameResponse(@JsonProperty("teamName") String teamName) {
        this.teamNName = teamName;
    }
}
