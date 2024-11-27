package com.example.reviewMember.member.infrastructure;

import com.example.reviewMember.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member,Long> {

    Member findByEmailAndPasswordOrderByIdDesc(String email, String password);
}
