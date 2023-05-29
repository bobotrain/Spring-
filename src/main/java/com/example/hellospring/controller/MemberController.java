package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    //alt + enter로 생성자 바로 만들기

    @Autowired //autowired를 써야 해당 서비스를 연결.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



}
