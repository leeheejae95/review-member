package com.example.reviewMember.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);

    Member findByEmailAndPasswordOrderByIdDesc(String email, String password);
}