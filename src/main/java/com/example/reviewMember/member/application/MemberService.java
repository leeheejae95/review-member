package com.example.reviewMember.member.application;

import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.domain.MemberRepository;
import com.example.reviewMember.member.presentation.UserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member create(UserInfoRequest userInfoRequest) {

        var entity = Member.builder()
                .email(userInfoRequest.getEmail())
                .name(userInfoRequest.getName())
                .build();

        return memberRepository.save(entity);
    }

    public Optional<Member> findId(UserInfoRequest userInfoRequest) {
        return Optional.ofNullable(memberRepository.findById(userInfoRequest.getId())
                .orElseThrow(NullPointerException::new)
        );
    }
}