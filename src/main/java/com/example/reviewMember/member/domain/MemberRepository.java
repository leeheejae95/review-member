package com.example.reviewMember.member.domain;

public interface MemberRepository {

    Member save(Member member);

    Member memberFind(String email, String password);
}