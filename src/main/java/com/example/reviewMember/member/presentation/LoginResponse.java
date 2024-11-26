package com.example.reviewMember.member.presentation;

import lombok.*;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String name;
    private String email;
    private String dept;
    private String manage;
}
