package kr.co.basic.web.sevice;

import kr.co.basic.web.dao.MemberDao;
import kr.co.basic.web.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password){
        memberDao.insert(username,password);
    }

    public List<Member> members(){
        return memberDao.members();
    }
}
