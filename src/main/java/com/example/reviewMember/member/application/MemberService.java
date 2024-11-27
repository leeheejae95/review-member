package com.example.reviewMember.member.application;

import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.domain.MemberRepository;
import com.example.reviewMember.member.infrastructure.api.Api;
import com.example.reviewMember.member.infrastructure.common.Role;
import com.example.reviewMember.member.infrastructure.error.ErrorCode;
import com.example.reviewMember.member.presentation.LoginRequest;
import com.example.reviewMember.member.presentation.MemberInfoRequest;
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
                .manage(userInfoRequest.getManage())
                .build();

        return memberRepository.save(entity);
    }
    public Object login(LoginRequest loginRequest) {

        var loginChk = memberRepository.memberFind(loginRequest.getEmail(), loginRequest.getPassword());
        if(loginChk == null) {
            return Api.ERROR(ErrorCode.NULL_PONINT,"해당 유저가 없습니다.");
        } else {
            return loginChk;
        }
    }

    public Member update(MemberInfoRequest memberInfoRequest) {

        var entity = Member.builder()
                .id(memberInfoRequest.getId())
                .email(memberInfoRequest.getEmail())
                .name(memberInfoRequest.getName())
                .password(passwordEncoder.encode(memberInfoRequest.getPassword()))
                .dept(memberInfoRequest.getDept())
                .status(Role.REGISTERED)
                .manage(memberInfoRequest.getManage())
                .build();

        return memberRepository.save(entity);
    }
}