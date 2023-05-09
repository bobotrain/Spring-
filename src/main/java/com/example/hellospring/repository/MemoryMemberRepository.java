package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될수도 있음 -> optional.ofNullable에 담으면 null이라도 감싸서 반환할 수 있다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findById(String name) {
        //람다식 사용 : 파라미터로 넘어온 name이랑 member.getName()의 값이 같은지 확인
        // 같으면 필터링이 됨 , 끝까지 같은것을 못찾으면 optional에 null이 포함되어서 반환된다.
        store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        return null;
    }

    @Override
    public List<Member> findAll() {
        //store은 members를 의미함. 이것들은 전체 반환. 
        return new ArrayList<>(store.values());
    }
}
