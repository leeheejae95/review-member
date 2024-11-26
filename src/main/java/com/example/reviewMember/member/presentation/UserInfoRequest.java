package com.example.reviewMember.member.presentation;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoRequest {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String dept;
    private String manage;
}
