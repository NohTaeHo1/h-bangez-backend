package com.bangez.user.service.impl;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangez.user.domain.dto.ArticleDto;
import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.model.Article;
import com.bangez.user.repository.ArticleRepository;
import com.bangez.user.service.ArticleService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;


    @Override
    public Messenger save(ArticleDto dto) {
        repository.save(dtoToEntity(dto));
        return Messenger.builder().message("성공").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder().message("삭제 성공").build();
    }

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public Article modify(Long id, Article newArticle) {
        return repository.findById(id).map(article -> {
            if (newArticle.getPostTitle() !=null){
                article.setPostTitle(newArticle.getPostTitle());
            }
            if (newArticle.getPostContent() !=null) {
                article.setPostContent(newArticle.getPostContent());
            }
            return repository.save(article);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}