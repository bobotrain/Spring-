package com.example.hellospring.service;

import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Configuration;


//자바코드로 직접 스프링 빈 등록하기
// @Service와 @Repository @Autowired가 없는 상황 ( 컴포넌트 스캔방식 아닐때.. ) -> 컨트롤러는 있음 주의
// 다음 configuration을 통해서 ,bean 을 등록함 ( service와 repository )


/*@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();

    }

//참고: 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
//그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로
//등록한다.

}*/
