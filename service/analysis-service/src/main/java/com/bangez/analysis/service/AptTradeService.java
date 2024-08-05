package com.bangez.analysis.service;

import com.bangez.analysis.domain.model.AptTradeBoxPlot;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface AptTradeService {
    Mono<Map<String, AptTradeBoxPlot>> getPriceStatistics();
}
