package com.bangez.analysis.service;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface AccessLogService {

    Mono<Void> recordPageVisit();
    Mono<Map<String, Long>> getTodayAccessCount();
}
