package com.bangez.analysis.service;

import com.bangez.analysis.domain.dto.SchoolDto;
import com.bangez.analysis.domain.model.School;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SchoolService {

    Mono<List<SchoolDto>> findAll();

    default Mono<SchoolDto> documentToDto(School document) {
        SchoolDto dto = SchoolDto.builder()
                .schoolId(document.getSchoolId())
                .address(document.getAddress())
                .homepage(document.getHomepage())
                .schoolName(document.getSchoolName())
                .schoolType(document.getSchoolType())
                .build();
        return Mono.just(dto);
    }

    default Mono<School> dtoToDocument(SchoolDto dto) {

        School school = School.builder()
                .schoolId(dto.getSchoolId())
                .address(dto.getAddress())
                .homepage(dto.getHomepage())
                .schoolName(dto.getSchoolName())
                .schoolType(dto.getSchoolType())
                .build();
        return Mono.just(school);

    }
}