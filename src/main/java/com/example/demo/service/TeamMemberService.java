package com.example.demo.service;

import com.example.demo.common.TeamMember;
import com.example.demo.data.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    TeamMemberRepository repository;

    public TeamMemberService(TeamMemberRepository repository) {
        this.repository = repository;
    }

    public List<TeamMember> getAllTeamMembers() {
         return null;
    }
}
