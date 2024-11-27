package com.example.reviewMember.member.infrastructure;

import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.domain.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryAdaptor implements MemberRepository {

    private final MemberJpaRepository jpaRepository;

    public MemberRepositoryAdaptor(MemberJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public Member save(Member member) {
        return jpaRepository.save(member);
    }

    @Override
    public Member memberFind(String email, String password) {
        return jpaRepository.findByEmailAndPasswordOrderByIdDesc(email, password);
    }
}
