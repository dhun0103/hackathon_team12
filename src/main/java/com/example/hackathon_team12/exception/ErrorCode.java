package com.example.hackathon_team12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND.value(), "M001", "유저가 존재하지 않습니다."),
//
//    DELETED_USER_EXCEPTION(HttpStatus.BAD_REQUEST.value(),"M002" ,"이미 탈퇴한 계정입니다.\n다른 계정으로 시도해 주세요." ),

    Not_Found_Post(HttpStatus.NOT_FOUND.value(), "P001", "게시물을 찾을 수 없습니다."),
    Not_Match_User(HttpStatus.BAD_REQUEST.value(), "P002", "작성자가 일치하지 않습니다."),
    Not_Found_Comment(HttpStatus.NOT_FOUND.value(), "P003", "댓글이 존재하지 않습니다."),



    ERROR(HttpStatus.NO_CONTENT.value(),"S001","알수없는오류");

    private final int status;
    private final String code;
    private final String message;
}
