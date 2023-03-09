package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 가져다 연결시켜줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
