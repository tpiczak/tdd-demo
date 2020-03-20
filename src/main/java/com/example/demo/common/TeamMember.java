package com.example.demo.common;

import java.util.Objects;

public class TeamMember {
    public String userId;
    public String firstName;
    public String lastName;
    public String team;

    public TeamMember(String userId, String firstName, String lastName, String team) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember that = (TeamMember) o;
        return userId.equals(that.userId) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, team);
    }

}
