package com.bangez.analysis.repository.impl;
import com.bangez.analysis.domain.model.AptTrade;
import com.bangez.analysis.repository.AptTradeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AptTradeDaoImpl implements AptTradeDao{
    private final ReactiveMongoOperations operations;
    @Override
    public Mono<Map<String, Long>> plotGraphAvgCostByDate() {
        Criteria criteria = new Criteria();

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("trade_price");

        return operations.find(query, AptTrade.class)
                .collect(Collectors.groupingBy(i->i.getContractDate(),
                        Collectors.collectingAndThen(Collectors.averagingLong(i->i.getTradePrice()), i-> i.longValue())));
    }
    @Override
    public Mono<Map<String,Long>> plotGraphSaleCountByDate() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.fields().include("contract_date");

        return operations.find(query, AptTrade.class)
                .flatMap(i -> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .build()))
                .collect(Collectors.groupingBy(i->i.getContractDate(), Collectors.counting()));

    }
    @Override
    public Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date) {
        Criteria criteria = Criteria.where("contract_date").regex("^" + date);
        Query query = new Query(criteria);
        query.fields().include("contract_date").include("ward");

        return operations.find(query, AptTrade.class)
                .flatMap(i -> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .ward(i.getWard())
                        .build()))
                .collect(Collectors.groupingBy(i-> i.getContractDate(), Collectors.counting()));
    }
    @Override
    public Mono<Map<Long, Long>> plotGraphCostByArea() {
        Criteria criteria = new Criteria();

        Query query = new Query();
        query.fields().include("net_leasable_area").include("price_per_area");

        return operations.find(query, AptTrade.class)
                .doOnNext(i-> System.out.println(i))
                .collectMap(i-> (long) (i.getNetLeasableArea().floatValue()/3.3), i-> (long) i.getPricePerArea().floatValue());
    }

  
    @Override
    public Mono<Map<String,Long>> tardeCountRaiseTop5ForMonth() {
        LocalDate now = LocalDate.now();
        String aYearAgo = now.minusYears(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Criteria criteria = Criteria.where("contract_date").gte(aYearAgo);

        Query query = new Query(criteria);
        query.fields().include("apt_name");

        List<Map<String, Long>> list = new ArrayList<>();
        return operations.find(query, AptTrade.class)
                .collect(Collectors.groupingBy(i -> i.getAptName(), Collectors.counting()))

                .flatMap(map -> {
                    Map<String, Long> sortedMap = map.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(5)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    return Mono.just(sortedMap);
                });
    }
}
