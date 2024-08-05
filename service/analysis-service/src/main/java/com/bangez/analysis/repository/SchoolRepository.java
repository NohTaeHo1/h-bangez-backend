package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.School;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SchoolRepository extends ReactiveMongoRepository<School, String> {
    Flux<School> findAll();

}
