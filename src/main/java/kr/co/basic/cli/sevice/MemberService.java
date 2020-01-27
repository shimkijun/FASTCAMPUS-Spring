package kr.co.basic.cli.sevice;

import kr.co.basic.cli.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@AllArgsConstructor
public class MemberService {
    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) throws SQLException {
        memberDao.insert(username,password);
    }

    public void print() throws SQLException {
        memberDao.print();
    }
}
