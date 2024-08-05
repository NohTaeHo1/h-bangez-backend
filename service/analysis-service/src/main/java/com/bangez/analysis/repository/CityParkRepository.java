package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.CityPark;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CityParkRepository extends ReactiveMongoRepository<CityPark, String>, CityParkDao {

    public Flux<CityPark> findAll();
}
