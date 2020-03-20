package com.example.demo.service;

import com.example.demo.common.TeamMember;
import com.example.demo.data.TeamMemberRepository;
import com.example.demo.provider.TeamNameProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamMemberServiceTest {

    @Mock
    TeamMemberRepository repository;

    @Mock
    TeamNameProvider provider;

    TeamMemberService subject;

    @BeforeEach
    void setUp() {
        subject = new TeamMemberService(repository, provider);
    }

    @Test
    void shouldReturnAllTeamMembersFromRepository() {
        when(provider.getTeamName("jlowrey")).thenReturn("Sentinel");
        when(repository.findAll()).thenReturn(asList(
                new TeamMember("tpicza1", "Tom", "Piczak", "Starflake"),
                new TeamMember("jlowrey", "Jon", "Lowrey", null)
        ));
        List<TeamMember> teamMembers = subject.getAllTeamMembers();
        assertNotNull(teamMembers);
        assertEquals(2, teamMembers.size());
        assertTrue(teamMembers.contains(
                new TeamMember("tpicza1", "Tom", "Piczak", "Starflake")));
        assertTrue(teamMembers.contains(
                new TeamMember("jlowrey", "Jon", "Lowrey", "Sentinel")));
        verifyNoMoreInteractions(repository, provider);

    }

    @Test
    void shouldReturnEmptyList_whenRepositoryReturnsNull(){
        when(repository.findAll()).thenReturn(null);
        List<TeamMember> teamMembers = subject.getAllTeamMembers();
        assertNotNull(teamMembers);
        assertEquals(0, teamMembers.size());
    }
}