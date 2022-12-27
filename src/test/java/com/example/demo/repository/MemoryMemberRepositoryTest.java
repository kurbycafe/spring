package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member= new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.err.println(result.toString());
        Assertions.assertEquals(result,member);
    }


}
