package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.AptTrade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface AptTradeRepository extends ReactiveMongoRepository<AptTrade, String> {
    Flux<AptTrade> findByLegalCode(String legalCode);
    Flux<AptTrade> findByWard(String region);

}