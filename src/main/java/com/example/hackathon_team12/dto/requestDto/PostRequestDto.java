package com.example.hackathon_team12.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostRequestDto {

    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String accountId;
    @NonNull
    private String pw;
}
