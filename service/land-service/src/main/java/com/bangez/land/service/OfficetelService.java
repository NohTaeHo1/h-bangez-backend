package com.bangez.land.service;



import com.bangez.land.domain.dto.OfficetelDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OfficetelService {
    Flux<OfficetelDto> getAllOfficetels();
    Mono<OfficetelDto> getOfficetelById(String id);
    Mono<OfficetelDto> createOfficetel(OfficetelDto officetelDTO);
    Mono<OfficetelDto> updateOfficetel(String id, OfficetelDto officetelDTO);
    Mono<Void> deleteOfficetel(String id);
}