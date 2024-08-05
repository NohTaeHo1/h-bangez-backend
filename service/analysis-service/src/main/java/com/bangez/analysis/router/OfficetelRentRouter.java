package com.bangez.analysis.router;

import com.bangez.analysis.repository.impl.OfficetelRentDaoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OfficetelRentRouter {
    private final OfficetelRentDaoRepositoryImpl repository;

    public Mono<?> execute(String select, String date, String region){

        return switch (select){
            case "1" -> repository.plotGraphAvgCostByDate();
            case "3" -> repository.plotGraphSalesCountByRegionForMonth(date, region);
            default -> null;
        };
    }
}
