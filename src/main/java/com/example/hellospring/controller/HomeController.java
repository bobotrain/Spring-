package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/") //localhost 8080 오면 이게 제일먼저 호출됨
    // 매핑사항이 없어지면 기존에 resource > static > index로 맞춰져 있던게 올 것.
    // 내장 통켓서버가 스프링컨테이너 에서 매핑사항을 찾고 ( "/") 그 이후에 못찾으면 static resource를 가리키기 때문.
    public String home() {
        return "home";
    }
}