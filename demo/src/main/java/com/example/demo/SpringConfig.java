package com.example.demo;


import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
