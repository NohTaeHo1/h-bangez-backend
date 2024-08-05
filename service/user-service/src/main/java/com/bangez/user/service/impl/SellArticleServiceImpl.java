package com.bangez.user.service.impl;

import com.bangez.user.domain.dto.SellArticleDto;
import com.bangez.user.domain.model.SellArticle;
import com.bangez.user.domain.vo.MessengerVO;
import com.bangez.user.repository.SellArticleRepository;
import com.bangez.user.service.SellArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellArticleServiceImpl implements SellArticleService {

    private final SellArticleRepository repository;


    @Override
    public MessengerVO save(SellArticleDto dto) {
        repository.save(dtoToEntity(dto));
        return MessengerVO.builder().message("성공").build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return MessengerVO.builder().message("삭제 성공").build();
    }

    @Override
    public List<SellArticleDto> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public SellArticle modify(Long id, SellArticle newSellArticle) {
        return repository.findById(id).map(sellArticle -> {
            if (newSellArticle.getPostTitle() !=null){
                sellArticle.setPostTitle(newSellArticle.getPostTitle());
            }
            if (newSellArticle.getPostContent() !=null) {
                sellArticle.setPostContent(newSellArticle.getPostContent());
            }
            return repository.save(sellArticle);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}