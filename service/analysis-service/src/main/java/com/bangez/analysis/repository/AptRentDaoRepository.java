package com.bangez.analysis.repository;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface AptRentDaoRepository {

    Mono<Map<String, Long>> plotGraphAvgCostByDate();

    Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date, String region);

}
