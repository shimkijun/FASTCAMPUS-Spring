package kr.co.basic.web.dao;

import kr.co.basic.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public class MemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void  init(){
        jdbcTemplate.update("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        jdbcTemplate.update("insert into member(username,password) values ('hi','1234')");
    }

    @Transactional
    public void insert(String username, String password){
        jdbcTemplate.update("insert into member(username,password) values(?,?)",username,password);
    }

    public List<Member> members() {
        return jdbcTemplate.query("select * from member", (resultSet, i) -> new Member(resultSet));
    }
}
