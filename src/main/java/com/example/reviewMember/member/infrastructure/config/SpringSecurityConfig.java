package com.example.reviewMember.member.infrastructure.config;

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
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable); // HTTP 요청에 대한 보안 규칙 정의
        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/member").permitAll() // url 허용
                                .anyRequest().authenticated() // 그 외 모든 요청은 인증 사용
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 암호화
        return new BCryptPasswordEncoder();
    }
}
