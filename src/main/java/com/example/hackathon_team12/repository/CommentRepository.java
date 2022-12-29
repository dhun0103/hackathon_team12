package com.example.hackathon_team12.repository;

import com.example.hackathon_team12.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
