package kr.co.basic.web.controller;

import kr.co.basic.web.entity.Member;
import kr.co.basic.web.model.MemberDto;
import kr.co.basic.web.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        List<Member> members = memberService.members();
        if(!members.isEmpty()) {
            mv.addObject("members", members);
        }else{
            mv.setViewName("index");
        }
        return mv;
    }

    @RequestMapping("/create")
    public String create(MemberDto memberDto){
        ModelAndView mv = new ModelAndView("index");
        memberService.insert(memberDto.getUsername(),memberDto.getPassword());
        return "redirect:index";
    }
}
