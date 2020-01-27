package kr.co.basic.cli.dao;

import kr.co.basic.cli.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Slf4j
public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insert(String username, String password) throws SQLException {
        jdbcTemplate.update("insert into member(username,password) values(?,?)",username,password);
    }

    public void print() {
        List<Member> members = jdbcTemplate.query("select * from member", (resultSet, i) -> new Member(resultSet));
        members.forEach(member -> log.info("{}",member));
    }
}
