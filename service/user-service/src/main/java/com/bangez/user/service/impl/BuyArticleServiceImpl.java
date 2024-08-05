package com.bangez.user.service.impl;

import com.bangez.user.domain.dto.BuyArticleDto;
import com.bangez.user.domain.model.BuyArticle;
import com.bangez.user.domain.vo.MessengerVO;
import com.bangez.user.repository.BuyArticleRepository;
import com.bangez.user.service.BuyArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyArticleServiceImpl implements BuyArticleService {

    private final BuyArticleRepository repository;


    @Override
    public MessengerVO save(BuyArticleDto dto) {
        repository.save(dtoToEntity(dto));
        return MessengerVO.builder().message("성공").build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return MessengerVO.builder().message("삭제 성공").build();
    }

    @Override
    public List<BuyArticleDto> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public BuyArticle modify(Long id, BuyArticle newBuyArticle) {
        return repository.findById(id).map(buyArticle -> {
            if (newBuyArticle.getPostTitle() !=null){
                buyArticle.setPostTitle(newBuyArticle.getPostTitle());
            }
            if (newBuyArticle.getPostContent() !=null) {
                buyArticle.setPostContent(newBuyArticle.getPostContent());
            }
            return repository.save(buyArticle);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}