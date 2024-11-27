package com.example.reviewMember.member.infrastructure.exceptionHandler;

import com.example.reviewMember.member.infrastructure.api.Api;
import com.example.reviewMember.member.infrastructure.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE) // 가장 마지막에 실행 적용
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api<Object>> exception(Exception exception) {
        log.error("", exception);

        return ResponseEntity
                .status(500) //ResponseEntity status에 디폴트로 셋팅
                .body(
                        Api.ERROR(ErrorCode.SERVER_ERROR)
                );
    }
}
