package com.sparta.spring01.domain;

import com.sparta.spring01.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long boardID;

    @ManyToOne
    @JoinColumn(name = "Board_id")
    private Board board;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(Long boardID, String username, String comment){
        this.boardID = boardID;
        this.username = username;
        this.comment = comment;
    }

    public Comment(CommentDto commentDto){
        this.boardID = commentDto.getBoardID();
        this.username = commentDto.getUsername();
        this.comment = commentDto.getComment();

    }

    public void update(CommentDto commentDto){
        this.username = commentDto.getUsername();
        this.comment = commentDto.getComment();
    }
}