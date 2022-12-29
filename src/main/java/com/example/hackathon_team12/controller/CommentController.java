package com.example.hackathon_team12.controller;

import com.example.hackathon_team12.dto.requestDto.CheckRequestDto;
import com.example.hackathon_team12.dto.requestDto.CommentRequestDto;
import com.example.hackathon_team12.dto.responseDto.GlobalResponseDto;
import com.example.hackathon_team12.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public GlobalResponseDto<?> createComment(@PathVariable Long postId,
                                              @RequestBody CommentRequestDto commentRequestDto) {

        return commentService.createComment(postId, commentRequestDto);
    }

    @DeleteMapping("/{commentId}")
    public GlobalResponseDto<?> deleteComment(@PathVariable Long commentId,
                                              @RequestBody(required = false) CheckRequestDto checkRequestDto) {

        return commentService.deleteComment(commentId, checkRequestDto);
    }
}
