package com.example.reviewMember.member.presentation;

import com.example.reviewMember.member.application.MemberService;
import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.domain.api.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public Api<Member> register(@RequestBody UserInfoRequest userInfoRequest) {
        return Api.OK(memberService.register(userInfoRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(memberService.login(loginRequest));
    }

    @PostMapping("/memberUpdate")
    public ResponseEntity<Member> memberUpdate(@RequestBody MemberInfoRequest memberInfoRequest) {
        return ResponseEntity.ok(memberService.update(memberInfoRequest));
    }

    @PostMapping("/test")
    public ResponseEntity<Member> test(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(memberService.login(loginRequest));
    }

}