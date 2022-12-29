package com.example.hackathon_team12.dto.responseDto;

import com.example.hackathon_team12.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private String title;
    private String content;
    private List<CommentResponseDto> commentDtoList;

    public PostResponseDto(Post post, List<CommentResponseDto> commentDtoList){

        this.title= post.getTitle();
        this.content= post.getContent();
        this.commentDtoList=commentDtoList;
    }
}
