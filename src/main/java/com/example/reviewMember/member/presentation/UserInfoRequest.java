package com.example.reviewMember.member.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequest {

    private Long id;
    private String name;
    private String email;
}
