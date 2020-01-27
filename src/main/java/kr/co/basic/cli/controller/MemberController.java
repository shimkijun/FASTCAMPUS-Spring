package kr.co.basic.cli.controller;

import kr.co.basic.cli.sevice.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    public void insert(String username, String password){
        try {
            memberService.insert(username,password);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void print(){
        try {
            memberService.print();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
