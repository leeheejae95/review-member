package com.example.reviewMember.member.presentation;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class UserInfoResponse {

    private String name;
    private String email;
    private String password;
    private String role;
    private String dept;
    private String manage;
}
