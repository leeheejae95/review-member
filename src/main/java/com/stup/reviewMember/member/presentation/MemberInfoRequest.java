package com.stup.reviewMember.member.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoRequest {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String dept;
    private String manage;
}
