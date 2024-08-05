package com.bangez.analysis.repository.impl;
import com.bangez.analysis.repository.OfficetelRentDao;
import com.bangez.analysis.domain.model.OfficetelTrade;
import com.bangez.analysis.repository.OfficetelTradeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OfficetelTradeDaoImpl  implements OfficetelTradeDao {
    private final ReactiveMongoOperations operations;

    @Override
    public Mono<Map<String, Long>> plotGraphAvgCostByDate() {

        Criteria criteria = new Criteria();

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("trade_price");

        return operations.find(query, OfficetelTrade.class)
                .collect(Collectors.groupingBy(i->i.getContractDate(),
                        Collectors.collectingAndThen(Collectors.averagingLong(i->i.getTradePrice()), i-> i.longValue())));
    }
    @Override
    public Mono<Map<String,Long>> plotGraphSaleCountByDate() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.fields().include("contract_date");

        return operations.find(query, OfficetelTrade.class)
                .flatMap(i -> Mono.just(OfficetelTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .build()))
                .collect(Collectors.groupingBy(i->i.getContractDate(), Collectors.counting()));

    }
    @Override
    public Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date) {
        Criteria criteria = Criteria.where("contract_date").regex("^" + date);
        Query query = new Query(criteria);
        query.fields().include("contract_date").include("ward");

        return operations.find(query, OfficetelTrade.class)
                .flatMap(i -> Mono.just(OfficetelTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .ward(i.getWard())
                        .build()))
                .collect(Collectors.groupingBy(i-> i.getContractDate(), Collectors.counting()));
    }
    @Override
    public Mono<Map<Long, Long>> plotGraphCostByArea() {
        Criteria criteria = new Criteria();

        Query query = new Query(criteria);
        query.fields().include("net_leasable_area").include("price_per_area");

        return operations.find(query, OfficetelTrade.class)
                .doOnNext(i-> System.out.println(i))
                .collectMap(i-> (long) (i.getNetLeasableArea().floatValue()/3.3), i-> (long) i.getPricePerArea().floatValue());
    }
}
