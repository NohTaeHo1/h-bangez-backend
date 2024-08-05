package com.bangez.analysis.repository;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface OfficetelTradeDaoRepository {

    Mono<Map<String, Long>> plotGraphAvgCostByDate();

    Mono<Map<String,Long>> plotGraphSaleCountByDate();

    Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date, String region);

    Mono<Map<Long, Long>> plotGraphCostByArea();
}
