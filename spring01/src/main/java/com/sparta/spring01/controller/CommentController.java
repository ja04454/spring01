package com.sparta.spring01.controller;


import com.sparta.spring01.domain.Comment;
import com.sparta.spring01.dto.CommentDto;
import com.sparta.spring01.repository.CommentRepository;
import com.sparta.spring01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    /*
     * 댓글 목록 조회
     * -작성일 기준 내림차순
     * */
    @GetMapping("/api/comments/{boardID}")
    public List<Comment> getComments(@PathVariable Long boardID){
        return commentService.getComments(boardID);
    }

    /*
     * 댓글 작성
     * - 비워둔 채 작성하면 메세지 return
     * */
    @PostMapping("/api/comments")
    public String createComment(@RequestBody CommentDto commentDto){
        if (commentDto.getComment().isEmpty()){
            return "댓글 내용을 입력해주세요.";
        }
        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);
        return "Good";
    }

    /*
     * 댓글 수정
     * - 비워둔 채 수정하면 메세지 return
     * */
    @PutMapping("/api/comments/{id}")
    public String updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        if (commentDto.getComment().isEmpty()){
            return "댓글 내용을 입력해주세요.";
        }
        commentService.update(id, commentDto);
        return "Nice";
    }

    /*
     * 댓글 삭제
     * */
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }

}