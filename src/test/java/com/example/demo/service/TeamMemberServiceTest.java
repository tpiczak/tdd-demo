package com.example.demo.service;

import com.example.demo.common.TeamMember;
import com.example.demo.data.TeamMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamMemberServiceTest {

    @Mock
    TeamMemberRepository repository;

    TeamMemberService subject;

    @BeforeEach
    void setUp() {
        subject = new TeamMemberService(repository);
    }

    @Test
    public void shouldReturnTeamMembers() {
        when(repository.findAll()).thenReturn(asList(
                new TeamMember("tpicza1", "Tom", "Piczak", "Starflake", "url1"),
                new TeamMember("jlowrey", "Jon", "Lowrey", null, "url2")
        ));
    }
}