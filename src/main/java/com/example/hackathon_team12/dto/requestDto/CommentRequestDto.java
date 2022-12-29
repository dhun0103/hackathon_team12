package com.example.hackathon_team12.dto.requestDto;

import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
public class CommentRequestDto {

    @NotBlank
    private String comment;
    @NotBlank
    private String accountId;
    @NotBlank
    private String pw;
}
