package com.bangez.user.service;


import com.bangez.user.domain.dto.BuyArticleDto;
import com.bangez.user.domain.model.BuyArticle;
import com.bangez.user.domain.vo.MessengerVO;

import java.util.Collections;
import java.util.List;

public interface BuyArticleService {
    MessengerVO save(BuyArticleDto buyArticleDTO);
    MessengerVO deleteById(Long id);
    List<BuyArticleDto> findAll();
    BuyArticle modify(Long id, BuyArticle newBuyArticle);


    default BuyArticleDto entityToDTO(BuyArticle buyArticle){
        return BuyArticleDto.builder()
                .id(buyArticle.getId())
                .postTitle(buyArticle.getPostTitle())
                .postContent(buyArticle.getPostContent())
                .postDate(buyArticle.getPostDate())
                .boardHits(buyArticle.getBoardHits())
                .buildType(buyArticle.getBuildType())
                .tradeType(buyArticle.getTradeType())
                .location(buyArticle.getLocation())
                .rentPrice(buyArticle.getRentPrice())
                .monthPrice(buyArticle.getMonthPrice())
                .tradePrice(buyArticle.getTradePrice())
                .size(buyArticle.getSize())
                .roomCount(buyArticle.getRoomCount())
                .toiletCount(buyArticle.getToiletCount())
                .numberOfApt(buyArticle.getNumberOfApt())
                .acceptForUse(buyArticle.getAcceptForUse())
                .parking(buyArticle.getParking())
                .convenient(Collections.singletonList(buyArticle.getConvenient()))
                .floor(buyArticle.getFloor())
                .hopeMove(buyArticle.getHopeMove())
                .moreContent(buyArticle.getMoreContent())
                .status(buyArticle.getStatus())
                .build();
    }

    default BuyArticle dtoToEntity(BuyArticleDto dto) {
        return BuyArticle.builder()
                .id(dto.getId())
                .postTitle(dto.getPostTitle())
                .postContent(dto.getPostContent())
                .postDate(dto.getPostDate())
                .boardHits(dto.getBoardHits())
                .buildType(dto.getBuildType())
                .tradeType(dto.getTradeType())
                .location(dto.getLocation())
                .rentPrice(dto.getRentPrice())
                .monthPrice(dto.getMonthPrice())
                .tradePrice(dto.getTradePrice())
                .size(dto.getSize())
                .roomCount(dto.getRoomCount())
                .toiletCount(dto.getToiletCount())
                .numberOfApt(dto.getNumberOfApt())
                .acceptForUse(dto.getAcceptForUse())
                .parking(dto.getParking())
                .convenient(dto.getConvenient().toString())
                .floor(dto.getFloor())
                .hopeMove(dto.getHopeMove())
                .moreContent(dto.getMoreContent())
                .status(dto.getStatus())
                .build();
    }


}