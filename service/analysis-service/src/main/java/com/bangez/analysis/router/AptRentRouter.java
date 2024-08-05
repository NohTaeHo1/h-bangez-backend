package com.bangez.analysis.router;

import com.bangez.analysis.repository.AptRentRepository;
import com.bangez.analysis.repository.impl.AptRentDaoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AptRentRouter {

    private final AptRentDaoRepositoryImpl repository;

    public Mono<?> execute(String select, String date, String region){

        return switch (select){
            case "1" -> repository.plotGraphAvgCostByDate();
            case "3" -> repository.plotGraphSalesCountByRegionForMonth(date, region);

            default -> null;
        };
    }
}
