package com.example.reviewMember.member.presentation;

import com.example.reviewMember.member.application.MemberService;
import com.example.reviewMember.member.domain.Member;
import com.example.reviewMember.member.infrastructure.api.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "", name = "회원가입")
    public Api<Member> register(@RequestBody UserInfoRequest userInfoRequest) {
        return Api.OK(memberService.register(userInfoRequest));
    }

    @PostMapping(value = "/login", name = "로그인")
    public Api<Object> login(@RequestBody LoginRequest loginRequest) {
        return Api.OK(memberService.login(loginRequest));
    }

    @PostMapping(value = "/memberUpdate", name = "회원정보 수정")
    public Api<Member> memberUpdate(@RequestBody MemberInfoRequest memberInfoRequest) {
        return Api.OK(memberService.update(memberInfoRequest));
    }

    @PostMapping(value = "/test", name = "시큐리티 테스트")
    public Api<Object> test(@RequestBody LoginRequest loginRequest) {
        return Api.OK(memberService.login(loginRequest));
    }

    @GetMapping(value = "/test2", name = "에러코드 테스트")
    public Api<LoginResponse> test() {

        var response = LoginResponse.builder()
                .name("홍길동")
                .email("test@test.com")
                .build();

        var str = "어렵다...";
        var age = Integer.parseInt(str);

        return Api.OK(response);
    }
}