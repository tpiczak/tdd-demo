package com.example.demo.data;

import com.example.demo.common.TeamMember;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamMemberRepository {

    JdbcTemplate jdbcTemplate;

    public TeamMemberRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public List<TeamMember> findAll() {
        return jdbcTemplate.query("SELECT * FROM team_member", (rs, rowNum) -> new TeamMember(
                rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5)));
    }

    public Optional<TeamMember> findByUserId(String userId) {
        return Optional.ofNullable(jdbcTemplate.query("SELECT * FROM team_member WHERE user_id = ?",
                rs -> rs.next() ? new TeamMember(
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)) : null,
                userId));
    }
}
