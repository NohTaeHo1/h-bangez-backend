package com.bangez.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Builder
public class ArticleDto {
    private Long id;
    private String postTitle;  //제목
    private String postContent;  //내용
    private LocalDate postDate;  //시간
    private int boardHits;  //조회수
    private Long postType;  //게시글 타입
}