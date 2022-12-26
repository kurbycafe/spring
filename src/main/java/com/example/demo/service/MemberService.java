package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    * 회원가입
    *
    * */
    public Long join(Member member){
        getMemberIsAlreadyExist(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void getMemberIsAlreadyExist(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(member1 -> {
                throw new IllegalStateException("member is already Exist");
          });
    }

    /*
    * 회원 리스트 조회
    * */
    public List<Member> FindMember(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memId){
        return memberRepository.findById(memId);
    }
}
