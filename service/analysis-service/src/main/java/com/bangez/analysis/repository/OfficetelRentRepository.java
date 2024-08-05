package com.bangez.analysis.repository;

import com.bangez.analysis.domain.model.OfficetelRent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficetelRentRepository extends ReactiveMongoRepository<OfficetelRent, String> {
}
