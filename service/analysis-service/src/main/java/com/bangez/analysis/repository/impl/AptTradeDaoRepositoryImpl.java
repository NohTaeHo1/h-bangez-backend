package com.bangez.analysis.repository.impl;

import com.bangez.analysis.domain.model.AptTrade;
import com.bangez.analysis.repository.AptTradeDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AptTradeDaoRepositoryImpl implements AptTradeDaoRepository {
    private final ReactiveMongoOperations operations;


    @Override
    public Mono<Map<String, Long>> plotGraphAvgCostByDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

        Criteria criteria = Criteria.where("contract_date")
                .gte(YearMonth.now().minusYears(1).format(formatter)+"01").lte(YearMonth.now().format(formatter)+"01");

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("trade_price");

        return operations.find(query, AptTrade.class)
                .flatMap(i-> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .tradePrice(i.getTradePrice())
                        .build()))
                .collect(Collectors.groupingBy(i->i.getContractDate(),
                        Collectors.collectingAndThen(Collectors.averagingLong(i->i.getTradePrice()), i-> i.longValue())));
    }

    @Override
    public Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date, String region) {
        Criteria criteria = Criteria.where("contract_date").regex("^" + date);

        switch (region){
            case "north":
                criteria.and("ward").in("강북구", "도봉구", "노원구", "성북구", "동대문구", "중랑구");
                break;
            case "south":
                criteria.and("ward").in("강남구", "서초구", "송파구", "관악구", "금천구", "구로구");
                break;
            case "east":
                criteria.and("ward").in("광진구", "성동구", "중구", "용산구", "동작구");
                break;
            case "west":
                criteria.and("ward").in("강서구", "양천구", "마포구", "서대문구", "은평구", "종로구");
                break;
            default:
                criteria.and("ward").in("강북구");
        }

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("ward");

        return operations.find(query, AptTrade.class)
                .flatMap(i -> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .ward(i.getWard())
                        .build()))
                .collect(Collectors.groupingBy(i-> i.getWard(), Collectors.counting()));
    }


    @Override
    public Mono<Map<String,Long>> tradeCountRaiseTop5ForMonth() {
        LocalDate now = LocalDate.now();
        String aYearAgo = now.minusYears(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Criteria criteria = Criteria.where("contract_date").gte(aYearAgo);

        Query query = new Query(criteria);
        query.fields().include("apt_name").include("ward");

        return operations.find(query, AptTrade.class)
                .collect(Collectors.groupingBy(i -> new AbstractMap.SimpleEntry<>(i.getAptName(), i.getWard()), Collectors.counting()))
                .flatMap(map -> {
                    Map<String, Long> sortedMap = map.entrySet().stream()
                            .sorted(Map.Entry.<AbstractMap.SimpleEntry<String, String>, Long>comparingByValue().reversed())
                            .limit(5)
                            .collect(Collectors.toMap(
                                    e -> e.getKey().getKey() + " (" + e.getKey().getValue() + ")",
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    return Mono.just(sortedMap);
                });
    }
}
