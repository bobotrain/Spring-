package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //반드시 서비스 넣어줘야 스프링 컨트롤러가 autowired할 때 인식함.
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //ctrl + shift + t 로 테스트 코드 한번에 만들기 가능 ( 껍데기 만 )
    
    
    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증

        //save메서드를 살펴보면
        memberRepository.save(member);
        return member.getId();   //회원가입하면 아이디(번호)만 반환해주겠다.



    }

    //중복회원검증 함수
    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복회원은 안된다. findByName은 optional임 -> optional을 쓰면 null이여도 문제 x
        //만약 result에 값이 있으면 해당 로직 동작 (람다)
        memberRepository.findByName(member.getName())
                .ifPresent(m-> { //중복이 있는 경우
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        //그냥 result.get으로 꺼내도됨~
    }

    //전체회원조회 ( repository참고해서 변수타입 맞춰주기 : list<member> )
    public List<Member> findMembers() {
        //MemberRepository의 list중 하나인 findAll 가져오기
        return memberRepository.findAll();
    }

    //회원한명조회 ( repository참고해서 변수타입 맞춰주기 : Optional<member> )
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
