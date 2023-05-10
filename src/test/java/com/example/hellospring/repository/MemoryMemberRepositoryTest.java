package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();


    //test code는 서로 의존관계없이 실행이 되어야 한다. 하지만 이 AfterEach구문에서 clearStore을 (repository 비워주는 역할)
    //실행해서 값을 비우지 않으면 첫번째 테스트가 두번째,세번째 테스트에도 영향을 미쳐 테스트 실패라는 결과를 야기한다.
    //따라서 AfterEach구문으로 data를 clear해주는 것을 잊지말자!
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

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
        //이렇게하면 true로밖에 확인 못하니까 아래의 assertions를 사용한다.
        //왼쪽이 기대하는 값 적는 것.
        Assertions.assertEquals(member, result);
        //assertion은 문제가 없을 때 아무 값도 안나오고 , 문제가 있으면 빨강으로 표시됨
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        Assertions.assertEquals(2, result.size());
        //테스트 잘못나온거 분석가능.
    }


}
