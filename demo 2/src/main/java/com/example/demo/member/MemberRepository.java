package com.example.demo.member;

public interface MemberRepository {
    void sava(Member member);

    Member findById(Long memberId);
}
