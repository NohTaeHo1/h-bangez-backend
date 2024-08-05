package com.bangez.analysis.service.impl;

import com.bangez.analysis.domain.model.AccessLog;
import com.bangez.analysis.repository.AccessLogRepository;
import com.bangez.analysis.service.AccessLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccessLogServiceImpl implements AccessLogService {

    private final AccessLogRepository repository;

    @Override
    public Mono<Void> recordPageVisit() {
        AccessLog log = new AccessLog();
        log.setAccessTime(LocalDateTime.now());
        return repository.save(log).then(); // 로그를 저장한 후 완료
    }

    @Override
    public Mono<Map<String, Long>> getTodayAccessCount() {
        LocalDateTime todayStart = LocalDateTime.now().toLocalDate().atStartOfDay();
        return repository.findByAccessTimeAfter(todayStart)
                .count()  // Count the number of logs
                .map(count -> {
                    Map<String, Long> result = new HashMap<>();
                    result.put("count", count);
                    return result;
                });
    }


}
