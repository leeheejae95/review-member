package com.stup.reviewMember.member.domain;

public interface MemberRepository {

    Member save(Member member);

    Member memberFind(String email, String password);
}