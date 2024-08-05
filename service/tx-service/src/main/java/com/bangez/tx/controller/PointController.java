package com.bangez.tx.controller;

import com.bangez.tx.domain.dto.PointDto;
import com.bangez.tx.service.impl.PointServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {
    private final PointServiceImpl service;

    @GetMapping("/detail/{userId}")
    public ResponseEntity<Integer> getPointDetail(@PathVariable("userId") Long id){
        log.info("포인트 디테일 id: {}",id);
        return ResponseEntity.ok(service.getPointDetail(id));
    }

    @PutMapping("/deduction/{userId}") // 포인트 차감 / accesstoken 코드 받으면 @PathVariable 지우고, accessToken 으로 id 찾기
    public ResponseEntity<PointDto> deductionPoint(@PathVariable("userId") Long userId){
        log.info("id: {}",userId);
        return ResponseEntity.ok(service.deductionPoint(userId));
    }

}


