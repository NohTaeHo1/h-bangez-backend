package com.bangez.analysis.router;
import com.bangez.analysis.repository.AptTradeRepository;
import com.bangez.analysis.repository.impl.AptTradeDaoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AptTradeRouter {
    private final AptTradeDaoRepositoryImpl repository;

    public Mono<?> execute(String select, String date, String region){

        return switch (select){
            case "1" -> repository.plotGraphAvgCostByDate();
            case "3" -> repository.plotGraphSalesCountByRegionForMonth(date, region);
            case "7" -> repository.tradeCountRaiseTop5ForMonth();

            default -> null;
        };
    }
}
