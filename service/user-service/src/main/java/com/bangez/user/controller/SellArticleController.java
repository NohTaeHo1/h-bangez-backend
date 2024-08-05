package com.bangez.user.controller;

import com.bangez.user.domain.dto.SellArticleDto;
import com.bangez.user.domain.model.SellArticle;
import com.bangez.user.domain.vo.MessengerVO;
import com.bangez.user.service.SellArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sell-article")
@RequiredArgsConstructor
@Slf4j
public class SellArticleController {

    private final SellArticleService service;

    @PostMapping("/save")
    public ResponseEntity<MessengerVO> save(@RequestBody SellArticleDto dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<MessengerVO> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<SellArticleDto>> findAll( ) {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<SellArticle> modify(@PathVariable Long id, @RequestBody SellArticle newSellArticle){
        log.info("입력받은 정보 : {}", newSellArticle);
        return ResponseEntity.ok(service.modify(id, newSellArticle));
    }


}