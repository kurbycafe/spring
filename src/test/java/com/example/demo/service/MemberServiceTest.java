package com.example.demo.service;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
MemberService memberService = new MemberService();
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}