package com.example.hackathon_team12.repository;

import com.example.hackathon_team12.domain.Post;
import com.example.hackathon_team12.enumclass.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedAtDesc();
    List<Post> findPostsByTagOrderByCreatedAtDesc(Tag tag);
}
