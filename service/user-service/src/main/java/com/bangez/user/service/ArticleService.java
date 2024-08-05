package com.bangez.user.service;




import java.util.List;

import com.bangez.user.domain.dto.ArticleDto;
import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.model.Article;

public interface ArticleService {
    Messenger save(ArticleDto articleDto);
    Messenger deleteById(Long id);
    List<ArticleDto> findAll();
    Article modify(Long id, Article newArticle);


    default ArticleDto entityToDTO(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .boardHits(article.getBoardHits())
                .postType(article.getPostType())
                .postContent(article.getPostContent())
                .postDate(article.getPostDate())
                .postTitle(article.getPostTitle())
                .build();
    }

    default Article dtoToEntity(ArticleDto dto){
        return Article.builder()
                .id(dto.getId())
                .boardHits(dto.getBoardHits())
                .postType(dto.getPostType())
                .postContent(dto.getPostContent())
                .postTitle(dto.getPostTitle())
                .build();
    }

}