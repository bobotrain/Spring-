package com.example.hellospring.controller;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    //alt + enter로 생성자 바로 만들기

    @Autowired //autowired를 써야 해당 서비스를 연결.
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        //회원가입 눌렀을때 members/new로 오기 때문에 여기 매핑을 거침
        //createMemberForm화면으로 이동
        return "members/createMemberForm";
    }

    //members/createMemberForm에서 입력한 것들(input타입 안 text들) form태그를 통해 submit -> post방식으로 넘어옴 > MemberFrom참고
    // 즉 여기 @PostMapping을 거치게 된다.
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) { //MemberForm을 거침 form이라는 변수명으로 설정
        Member member = new Member();

        //createMemberForm에서 setName을 통해 담아둔 name을 getName으로 호출하여 member에 담음 ( controller>MemberForm 참고 )
        member.setName(form.getName());
        
        //memberService에 만들어둔 join매서드 member를 담아서 실행 ( 담아둠 )
        memberService.join(member);
        
        //회원가입 끝났으니 home화면으로 돌려보냄
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        //아까 회원가입과정에서 담아둔 memberService값을 찾아와서 findMembers() 기능 실행 ( MemberService 참고 )
        //findMembers(); 는 memberRepository.findAll() (인터페이스) 을 의미함
        //결과값을 다시 list<Member> members에 담음
        List<Member> members = memberService.findMembers();
        //model이라는 리스트에 아예 members를 담어서 template에 넘길 꺼임
        model.addAttribute( "members", members);
        return "members/memberList";

    }

}
