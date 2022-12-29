package com.example.hackathon_team12.controller;

import com.example.hackathon_team12.dto.requestDto.CheckRequestDto;
import com.example.hackathon_team12.dto.requestDto.PostRequestDto;
import com.example.hackathon_team12.dto.requestDto.PostUpdateRequestDto;
import com.example.hackathon_team12.dto.responseDto.GlobalResponseDto;
import com.example.hackathon_team12.enumclass.Tag;
import com.example.hackathon_team12.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping
    public GlobalResponseDto<?> createPost(@RequestBody(required = false) PostRequestDto postRequestDto,
                                           @RequestParam(value = "tag") @Valid Tag tag) throws IOException {
        return postService.createPost(postRequestDto, tag);
    }

    // 게시글 수정
    @PutMapping("/{postId}")
    public GlobalResponseDto<?> updatePost(@PathVariable Long postId,
                                           @RequestBody(required = false) PostUpdateRequestDto postUpdateRequestDto,
                                           @RequestParam(value = "tag") @Valid Tag tag) throws IOException {


        return postService.updatePost(postId, postUpdateRequestDto, tag);
    }

    // 게시글 삭제
    @DeleteMapping("/{postId}")
    public GlobalResponseDto<?> deletePost(@PathVariable Long postId,
                                           @RequestBody(required = false) CheckRequestDto checkRequestDto) {
        return postService.deletePost(postId, checkRequestDto);
    }

    // 게시글 상세조회
    @GetMapping("/{postId}")
    public GlobalResponseDto<?> getOnePost(@PathVariable Long postId) {

        return postService.getOnePost(postId);
    }

    // 게시글 전체조회
    @GetMapping
    public GlobalResponseDto<?> getAllPost(@RequestParam(value = "tag", required = true, defaultValue = "All") Tag tag) {

        return postService.getAllPost(tag);
    }

    // 본인확인
    @PostMapping("/{postId}")
    public GlobalResponseDto<?> check(@PathVariable Long postId,
                                      @RequestBody(required = false) CheckRequestDto checkRequestDto) {

        return postService.checkPost(postId, checkRequestDto);
    }
}
