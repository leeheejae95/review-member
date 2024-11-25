package com.example.reviewMember.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByIdOrderByIdDesc(Long id);

//    Optional<Member> findByEmailOrderByIdDesc(String email);

//    Member save(Member member);
//    Optional<Member> findById(Long id);
}