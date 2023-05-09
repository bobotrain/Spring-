package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    //TEST 어노테이션넣고 실행해볼 수 있음. -> 테스트 케이스 작성
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        //+@ ctrl + shift + enter로 코드 마무리 가능
        repository.save(member);
        //저장할때, MemoryMemberRepository.java에서 id 세팅하는곳 참고. -> optional로 member 반환됨 확인.
        Member result = repository.findById(member.getId()).get();
        //인텔리제이 sysout빨리 뽑기 -> sout + ctrl +space
        System.out.println("result = " + (result == member));


    }

}
