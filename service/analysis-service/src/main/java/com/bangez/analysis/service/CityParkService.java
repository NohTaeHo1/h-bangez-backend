package com.bangez.analysis.service;

import com.bangez.analysis.domain.model.CityPark;
import com.bangez.analysis.domain.dto.CityParkDto;
import reactor.core.publisher.Mono;

import java.util.List;
public interface CityParkService {
    Mono<List<CityParkDto>> findAll();

    default Mono<CityParkDto> documentToDto(CityPark document) {
        CityParkDto dto = CityParkDto.builder()
                .cityParkId(document.getCityParkId())
                .address(document.getAddress())
                .area(document.getArea())
                .latitude(document.getLatitude())
                .longitude(document.getLongitude())
                .parkName(document.getParkName())
                .parkType(document.getParkType())
                .build();
        return Mono.just(dto);
    }

    default Mono<CityPark> dtoToDocument(CityParkDto dto) {

        CityPark cityPark = CityPark.builder()
                .cityParkId(dto.getCityParkId())
                .address(dto.getAddress())
                .area(dto.getArea())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .parkName(dto.getParkName())
                .parkType(dto.getParkType())
                .build();
        return Mono.just(cityPark);
    }
}
