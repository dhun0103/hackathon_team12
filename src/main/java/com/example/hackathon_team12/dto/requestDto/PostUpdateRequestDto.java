package com.example.hackathon_team12.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostUpdateRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
