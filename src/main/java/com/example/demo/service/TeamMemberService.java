package com.example.demo.service;

import com.example.demo.common.TeamMember;
import com.example.demo.data.TeamMemberRepository;
import com.example.demo.provider.TeamNameProvider;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class TeamMemberService {

    TeamMemberRepository teamMemberRepository;
    TeamNameProvider teamNameProvider;

    public TeamMemberService(TeamMemberRepository repository, TeamNameProvider teamNameProvider) {
        teamMemberRepository = repository;
        this.teamNameProvider = teamNameProvider;
    }

    public List<TeamMember> getAllTeamMembers() {
        List<TeamMember> list = Optional.ofNullable(teamMemberRepository.findAll()).orElse(Collections.emptyList());
        list.stream().filter(teamMember -> isEmpty(teamMember.team))
                .forEach(teamMember -> teamMember.team = teamNameProvider.getTeamName(teamMember.userId));
        return list;
    }
}
