package com.example.reviewMember.member.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic(AbstractHttpConfigurer::disable);
        http
                .csrf(AbstractHttpConfigurer::disable); // HTTP 요청에 대한 보안 규칙 정의
        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/member/login", "/member").anonymous() // url 허용
                                .requestMatchers("/member/**").hasRole("REGISTERED")
                                .anyRequest().permitAll() // 그 외 모든 요청은 인증 사용
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 암호화
        return new BCryptPasswordEncoder();
    }
}
