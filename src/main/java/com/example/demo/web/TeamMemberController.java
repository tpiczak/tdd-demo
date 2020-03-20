package com.example.demo.web;

import com.example.demo.common.TeamMember;
import com.example.demo.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamMemberController {

    @Autowired
    TeamMemberService service;

    @GetMapping("/getAllTeamMembers")
    List<TeamMember> getAllTeamMembers() {
        return service.getAllTeamMembers();
    }
}
