package com.example.hackathon_team12.domain;

import com.example.hackathon_team12.dto.requestDto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String pw;

    @JoinColumn(nullable = false)
    @JsonIgnore
    @ManyToOne
    private Post post;

    public Comment(CommentRequestDto commentRequestDto, Post post) {
        this.comment = commentRequestDto.getComment();
        this.post = post;
        this.accountId=commentRequestDto.getAccountId();
        this.pw=commentRequestDto.getPw();
    }
}
