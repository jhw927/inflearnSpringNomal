package com.example.demo.member;
// 인터페이스는 역할!
public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
