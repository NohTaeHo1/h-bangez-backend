package com.bangez.land.service;

import com.bangez.land.domain.dto.ApartmentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApartmentService {
    Flux<ApartmentDto> getAllApartments();
    Mono<ApartmentDto> getApartmentById(String id);
    Mono<ApartmentDto> createApartment(ApartmentDto apartmentDTO);
    Mono<ApartmentDto> updateApartment(String id, ApartmentDto apartmentDTO);
    Mono<Void> deleteApartment(String id);
    Flux<ApartmentDto> searchApartments(String tradTpNm, int minPrice, int maxPrice);
    Flux<ApartmentDto> searchApartmentsByPrice(int minPrice, int maxPrice);
    Flux<ApartmentDto> getFilteredApartments(String rletTpNm, String tradTpNm, Integer minPrc, Integer maxPrc, Integer minSpc1, Integer maxSpc1, String town);
}