package com.example.hackathon_team12.service;

import com.example.hackathon_team12.domain.Comment;
import com.example.hackathon_team12.domain.Post;
import com.example.hackathon_team12.dto.requestDto.CheckRequestDto;
import com.example.hackathon_team12.dto.requestDto.PostRequestDto;
import com.example.hackathon_team12.dto.requestDto.PostUpdateRequestDto;
import com.example.hackathon_team12.dto.responseDto.CommentResponseDto;
import com.example.hackathon_team12.dto.responseDto.GlobalResponseDto;
import com.example.hackathon_team12.dto.responseDto.PostAllResponseDto;
import com.example.hackathon_team12.dto.responseDto.PostResponseDto;
import com.example.hackathon_team12.enumclass.Tag;
import com.example.hackathon_team12.exception.CustomException;
import com.example.hackathon_team12.exception.ErrorCode;
import com.example.hackathon_team12.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public GlobalResponseDto<?> createPost(PostRequestDto postRequestDto, Tag tag) throws IOException{

        Post post = new Post(postRequestDto, tag);
        postRepository.save(post);

        return GlobalResponseDto.success(null, "작성이 완료되었습니다");
    }

    @Transactional
    public GlobalResponseDto<?> updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto, Tag tag) throws IOException {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Post)
        );

        post.update(postUpdateRequestDto, tag);

        return GlobalResponseDto.success(null, "수정이 완료되었습니다");

    }

    @Transactional
    public GlobalResponseDto<?> deletePost(Long postId, CheckRequestDto checkRequestDto) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Post)
        );

        if (checkRequestDto.getPw().equals(post.getPw())) {

            postRepository.deleteById(postId);

            return GlobalResponseDto.success(null, "삭제가 완료되었습니다");
        } else {
            throw new CustomException(ErrorCode.Not_Match_User);
        }
    }

    @Transactional
    public GlobalResponseDto<?> getOnePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Post)
        );

        List<CommentResponseDto> commentDtoList = new ArrayList<>();
        for (Comment comment : post.getComments()) {

            commentDtoList.add(new CommentResponseDto(comment));
        }

        return GlobalResponseDto.success(new PostResponseDto(post, commentDtoList), "조회가 완료되었습니다");
    }

    @Transactional
    public GlobalResponseDto<?> getAllPost(Tag tag) {
        List<Post> postList = new ArrayList<>();

        if (tag.equals("All")) {
            postList = postRepository.findAllByOrderByCreatedAtDesc();
        } else {
            postList = postRepository.findPostsByTagOrderByCreatedAtDesc(tag);
        }

        List<PostAllResponseDto> postAllResponseDtoList = new ArrayList<>();
        for (Post post: postList) {

            postAllResponseDtoList.add(new PostAllResponseDto(post));
        }

        return GlobalResponseDto.success(postAllResponseDtoList, "전체조회가 완료되었습니다");
    }

    @Transactional
    public GlobalResponseDto<?> checkPost(Long postId, CheckRequestDto checkRequestDto) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.Not_Found_Post)
        );

        if (checkRequestDto.getPw().equals(post.getPw())) {

            return GlobalResponseDto.success(null, "본인확인 되었습니다");
        } else {
            throw new CustomException(ErrorCode.Not_Match_User);
        }
    }

}
