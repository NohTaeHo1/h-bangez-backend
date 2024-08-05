package com.bangez.user.service;


import com.bangez.user.domain.dto.SellArticleDto;
import com.bangez.user.domain.model.SellArticle;
import com.bangez.user.domain.vo.MessengerVO;

import java.util.Collections;
import java.util.List;

public interface SellArticleService {
    MessengerVO save(SellArticleDto sellArticleDTO);
    MessengerVO deleteById(Long id);
    List<SellArticleDto> findAll();
    SellArticle modify(Long id, SellArticle newSellArticle);


    default SellArticleDto entityToDTO(SellArticle sellArticle){
        return SellArticleDto.builder()
                .id(sellArticle.getId())
                .postTitle(sellArticle.getPostTitle())
                .postContent(sellArticle.getPostContent())
                .postDate(sellArticle.getPostDate())
                .boardHits(sellArticle.getBoardHits())
                .buildType(sellArticle.getBuildType())
                .tradeType(sellArticle.getTradeType())
                .location(sellArticle.getLocation())
                .rentPrice(sellArticle.getRentPrice())
                .monthPrice(sellArticle.getMonthPrice())
                .tradePrice(sellArticle.getTradePrice())
                .size(sellArticle.getSize())
                .roomCount(sellArticle.getRoomCount())
                .toiletCount(sellArticle.getToiletCount())
                .numberOfApt(sellArticle.getNumberOfApt())
                .acceptForUse(sellArticle.getAcceptForUse())
                .parking(sellArticle.getParking())
                .convenient(Collections.singletonList(sellArticle.getConvenient()))
                .floor(sellArticle.getFloor())
                .hopeMove(sellArticle.getHopeMove())
                .status(sellArticle.getStatus())
                .build();
    }

    default SellArticle dtoToEntity(SellArticleDto dto) {
        return SellArticle.builder()
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
                .status(dto.getStatus())
                .build();
    }


}