package com.sparta.spring01.service;

import com.sparta.spring01.domain.Comment;
import com.sparta.spring01.dto.CommentDto;
import com.sparta.spring01.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service //스프링에게 서비스임을 명시
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long boardID){
        return commentRepository.findAllByBoardIDOrderByCreatedAtDesc(boardID);
    }

    @Transactional
    public Long update(Long id, CommentDto commentDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다")
        );
        comment.update(commentDto);
        return comment.getId();
    }

}