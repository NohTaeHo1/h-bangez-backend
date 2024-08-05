package com.bangez.analysis.controller;

import com.bangez.analysis.service.impl.AccessLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/today")
public class AccessLogController {

    private final AccessLogServiceImpl service;

    @PostMapping("/access-record")
    public Mono<Void> recordPageVisit() {
        return service.recordPageVisit(); // 로그를 데이터베이스에 저장
    }

    @GetMapping("/access-count")
    public Mono<Map<String, Long>> getTodayAccessCount() {
        return service.getTodayAccessCount();
    }}


