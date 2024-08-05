package com.bangez.land.repository;


import com.bangez.land.domain.model.OfficetelModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficetelRepository extends ReactiveMongoRepository<OfficetelModel, String> {
}