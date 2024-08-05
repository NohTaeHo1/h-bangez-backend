package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.AptRent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AptRentRepository extends ReactiveMongoRepository<AptRent, String>, AptRentDao {


}