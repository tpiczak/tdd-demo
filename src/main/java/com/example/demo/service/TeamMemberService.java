package com.example.demo.service;

import com.example.demo.common.TeamMember;
import com.example.demo.data.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class TeamMemberService {

    TeamMemberRepository repository;

    public TeamMemberService(TeamMemberRepository repository) {
        this.repository = repository;
    }

    public List<TeamMember> getAllTeamMembers() {
        List<TeamMember> list = Optional.ofNullable(repository.findAll()).orElse(Collections.emptyList());
        return list;
    }
}
