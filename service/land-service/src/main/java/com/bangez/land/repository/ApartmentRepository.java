package com.bangez.land.repository;


import com.bangez.land.domain.model.ApartmentModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ApartmentRepository extends ReactiveMongoRepository<ApartmentModel, String> {


    // Flux<ApartmentModel> findByTownAndPrcBetweenAndSpc1BetweenAndTradTpNm(String town, int minPrice, int maxPrice, double minArea, double maxArea, String tradTpNm);

    @Query("{ 'tradTpNm': ?0, 'prc': { $gte: ?1, $lte: ?2 } }")
    Flux<ApartmentModel> findByTradTpNmAndPrcBetween(String tradTpNm, int minPrice, int maxPrice);

    @Query("{ 'prc': { $gte: ?0, $lte: ?1 } }")
    Flux<ApartmentModel> findByPrcBetween(int minPrice, int maxPrice);

    @Query("{ 'rletTpNm': ?0, 'tradTpNm': ?1, 'prc': { $gte: ?2, $lte: ?3 }, 'spc1': { $gte: ?4, $lte: ?5 }, 'town': { $regex: ?6, $options: 'i' } }")
    Flux<ApartmentModel> findByCriteria(String rletTpNm, String tradTpNm, Integer minPrc, Integer maxPrc, Integer minSpc1, Integer maxSpc1, String town);

}