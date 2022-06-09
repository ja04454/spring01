package com.sparta.spring01.domain;

import com.sparta.spring01.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자
@Entity // 테이블과 연계되어 있음을 알린다
public class Board extends Timestamped { // 생성, 수정 시간을 자동으로 만들어준다

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Board_id")
    private Long id;

    @Column(nullable = false) // nullable=false -> NOT NULL
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    public Board(String title, String username, String content) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public Board(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.username = boardDto.getUsername();
        this.content = boardDto.getContent();
    }

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.username = boardDto.getUsername();
        this.content = boardDto.getContent();
    }
}
