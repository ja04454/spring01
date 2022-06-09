package com.sparta.spring01.service;

import com.sparta.spring01.domain.Board;
import com.sparta.spring01.dto.BoardDto;
import com.sparta.spring01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service //스프링에게 서비스임을 명시
public class BoardService {

    private final BoardRepository boardRepository; //final -> 한번 값이 부여되면 변형X

    @Transactional
    public Long update(Long id, BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다")
        );
        board.update(boardDto);
        return board.getId();
    }
}