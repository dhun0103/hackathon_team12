package com.example.hackathon_team12.dto.responseDto;

import com.example.hackathon_team12.domain.Post;
import lombok.Getter;

@Getter
public class PostAllResponseDto {

    private Long postId;
    private String title;
    private String content;

    public PostAllResponseDto(Post post){
        this.postId=post.getPostId();
        this.title=post.getTitle();
        this.content=post.getContent();
    }
}
