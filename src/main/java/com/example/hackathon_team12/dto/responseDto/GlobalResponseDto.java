package com.example.hackathon_team12.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GlobalResponseDto<T> {

    private String message;
    private int statusCode;


    public GlobalResponseDto(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
