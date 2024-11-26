package com.example.reviewMember.member.application;

import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.domain.MemberRepository;
import com.example.reviewMember.member.domain.common.Role;
import com.example.reviewMember.member.presentation.LoginRequest;
import com.example.reviewMember.member.presentation.UserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public Member register(UserInfoRequest userInfoRequest) {

        var entity = Member.builder()
                .email(userInfoRequest.getEmail())
                .name(userInfoRequest.getName())
                .password(passwordEncoder.encode(userInfoRequest.getPassword()))
                .dept(userInfoRequest.getDept())
                .status(Role.REGISTERED)
                .build();

        return memberRepository.save(entity);
    }
    public Member login(LoginRequest loginRequest) {
        return memberRepository.findByEmailAndPasswordOrderByIdDesc(loginRequest.getEmail(), loginRequest.getPassword());
    }
}