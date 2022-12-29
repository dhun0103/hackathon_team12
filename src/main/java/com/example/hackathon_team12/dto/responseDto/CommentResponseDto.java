package com.example.hackathon_team12.dto.responseDto;

import com.example.hackathon_team12.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private Long postId;
    private Long commentId;
    private String comment;

    public CommentResponseDto(Comment comment){
        this.commentId=comment.getCommentId();
        this.comment=comment.getComment();
    }
}
