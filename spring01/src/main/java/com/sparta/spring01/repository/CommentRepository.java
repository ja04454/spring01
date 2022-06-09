package com.sparta.spring01.repository;

import com.sparta.spring01.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardIDOrderByCreatedAtDesc(Long boardID);
}