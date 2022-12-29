package com.example.hackathon_team12.domain;

import com.example.hackathon_team12.dto.requestDto.PostRequestDto;
import com.example.hackathon_team12.dto.requestDto.PostUpdateRequestDto;
import com.example.hackathon_team12.enumclass.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends TimeStamped{

    @Id
    @Column(name = "postId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String pw;
    @Column(nullable = false)
    private Tag tag;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Post (PostRequestDto postRequestDto, Tag tag) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.accountId=postRequestDto.getAccountId();
        this.pw=postRequestDto.getPw();
        this.tag = tag;
    }

    public void update (PostUpdateRequestDto postUpdateRequestDto, Tag tag) {
        this.title = postUpdateRequestDto.getTitle();
        this.content = postUpdateRequestDto.getContent();
        this.tag = tag;
    }

}
