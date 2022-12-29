package com.example.hackathon_team12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND.value(), "M001", "유저가 존재하지 않습니다."),




    ERROR(HttpStatus.NO_CONTENT.value(),"S001","알수업는오류");


    private final int status;
    private final String code;
    private final String message;
}
