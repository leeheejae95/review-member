package com.example.reviewMember.member.presentation;

import com.example.reviewMember.member.application.MemberService;
import com.example.reviewMember.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public Member create(@RequestBody UserInfoRequest userInfoRequest) {

        return memberService.create(userInfoRequest);
    }
}
