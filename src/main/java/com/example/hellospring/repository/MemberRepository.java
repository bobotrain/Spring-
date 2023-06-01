package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//repository에 인터페이스 따로 정의. ( 자주쓰는 기능의 집합체 -> 한번에 가겠다! )
// 단순 기능 1개만 정의할 꺼면 그냥 service로 정의하는게 나음 ㅎㅎ
public interface MemberRepository {
    //save를 정의해 놓은 implementation 잘 살펴보기 ( MemoryMemberRepository참고 )
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    public void clearStore();
}
