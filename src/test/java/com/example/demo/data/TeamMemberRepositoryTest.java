package com.example.demo.data;

import com.example.demo.common.TeamMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
class TeamMemberRepositoryTest {

    TeamMemberRepository subject;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        subject = new TeamMemberRepository(jdbcTemplate);
    }

    @Test
    public void shouldReturnAllTeamMembers(){
        List<TeamMember> teamMembers = subject.findAll();
        assertNotNull(teamMembers);
        assertEquals(2, teamMembers.size());
        assertTrue(teamMembers.contains(new TeamMember("tpicza1", "Tom", "Piczak", "Starflake")));
        assertTrue(teamMembers.contains(new TeamMember("jlowrey", "Jon", "Lowrey", null)));
    }

    @Test
    public void shouldReturnSingleTeamMember_whenUserIdExists() {
        Optional<TeamMember> teamMember = subject.findByUserId("tpicza1");
        assertTrue(teamMember.isPresent());
        assertEquals(new TeamMember("tpicza1", "Tom", "Piczak", "Starflake"), teamMember.get());
    }

    @Test
    public void shouldReturnNull_whenUserIdDoesNotExist() {
        Optional<TeamMember> teamMember = subject.findByUserId("no_such_user");
        assertFalse(teamMember.isPresent());
    }
}

