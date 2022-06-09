package com.sparta.spring01.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class BoardDto{
    private String title;
    private String username;
    private String content;
}