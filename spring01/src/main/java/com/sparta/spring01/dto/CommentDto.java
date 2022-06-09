package com.sparta.spring01.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentDto {
    private Long boardID;
    private String comment;
    private String username;
}