package com.bangez.analysis.repository;
import reactor.core.publisher.Mono;

import java.util.Map;
public interface AptTradeDao {
    Mono<Map<String, Long>> plotGraphAvgCostByDate();

    Mono<Map<String,Long>> plotGraphSaleCountByDate();

    Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date);

    Mono<Map<Long, Long>> plotGraphCostByArea();

    Mono<Map<String,Long>> tardeCountRaiseTop5ForMonth();
    
}
