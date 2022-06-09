package com.sparta.spring01.controller;

import com.sparta.spring01.domain.Board;
import com.sparta.spring01.dto.BoardDto;
import com.sparta.spring01.repository.BoardRepository;
import com.sparta.spring01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


    /*
     * 게시글 작성
     * */
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardDto boardDto) {
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

    /*
     * 전체 게시글 목록 조회
     * -작성일 기준 내림차순
     **/
    @GetMapping("/api/boards")
    public List<Board> getBoards(){
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    /*
     * 게시글 조회
     * */
    @GetMapping("/api/boards/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다")
        );
    }

    /*
     * 게시글 수정
     * */
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
        return boardService.update(id, boardDto);
    }

    /*
     * 게시글 삭제
     * */
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }

}