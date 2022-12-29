package com.example.hackathon_team12.service;

import com.example.hackathon_team12.domain.Comment;
import com.example.hackathon_team12.domain.Post;
import com.example.hackathon_team12.dto.requestDto.CheckRequestDto;
import com.example.hackathon_team12.dto.requestDto.CommentRequestDto;
import com.example.hackathon_team12.dto.responseDto.GlobalResponseDto;
import com.example.hackathon_team12.exception.CustomException;
import com.example.hackathon_team12.exception.ErrorCode;
import com.example.hackathon_team12.repository.CommentRepository;
import com.example.hackathon_team12.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public GlobalResponseDto<?> createComment(Long postId, CommentRequestDto commentRequestDto) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Post)
        );
        Comment comment = new Comment(commentRequestDto, post);
        commentRepository.save(comment);

        return GlobalResponseDto.success(null, "작성이 완료되었습니다");
    }

    @Transactional
    public GlobalResponseDto<?> deleteComment(Long commentId, CheckRequestDto checkRequestDto) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Comment)
        );

        if (comment.getPw().equals(checkRequestDto.getPw())) {

            commentRepository.deleteById(commentId);

            return GlobalResponseDto.success(null, "삭제가 완료되었습니다");
        } else {
            throw new CustomException(ErrorCode.Not_Match_User);
        }
    }
}
