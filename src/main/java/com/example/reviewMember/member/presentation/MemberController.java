package com.example.reviewMember.member.presentation;

import com.example.reviewMember.member.application.MemberService;
import com.example.reviewMember.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<Member> create(@RequestBody UserInfoRequest userInfoRequest) {

        return ResponseEntity.ok(memberService.create(userInfoRequest));
    }

    @GetMapping("/login")
    public ResponseEntity<Optional<Member>> findUser(@RequestBody UserInfoRequest userInfoRequest) {
        return ResponseEntity.ok(memberService.findId(userInfoRequest));
    }
}