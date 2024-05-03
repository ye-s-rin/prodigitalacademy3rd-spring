package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MemberController {

    private MemberService memberService;

    MemberController(MemberService memberService) {

        this.memberService = memberService;
        System.out.println("MemberController 객체 생성");
    }

    public String call1() {
        return memberService.work1();
    }

    public String call2() {
        return memberService.work2();
    }

    public String call3() {
        return memberService.work3();
    }

    public String call4() {
        return memberService.work4();
    }
}
