package com.bangez.user.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bangez.user.domain.dto.ArticleDto;
import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.model.Article;
import com.bangez.user.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping(path = "/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService service;

    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody ArticleDto dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ArticleDto>> findAll( ) {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<Article> modify(@PathVariable Long id, @RequestBody Article newArticle){
        log.info("입력받은 정보 : {}",newArticle);
        return ResponseEntity.ok(service.modify(id, newArticle));
    }


}