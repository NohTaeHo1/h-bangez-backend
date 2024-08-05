package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.OfficetelTrade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficetelTradeRepository extends ReactiveMongoRepository<OfficetelTrade, String> {
}
