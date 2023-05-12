package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberSerivce = new MemberService();


    @Test
    void join() {//(회원가입)
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberSerivce.join(member);

        //then
        Member findMember = memberSerivce.findOne(saveId).get();



    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}