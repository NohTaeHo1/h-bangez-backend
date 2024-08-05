package com.bangez.analysis.service.impl;

import com.bangez.analysis.domain.dto.SchoolDto;
import com.bangez.analysis.repository.SchoolRepository;
import com.bangez.analysis.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;

    @Override
    public Mono<List<SchoolDto>> findAll(){
        return repository.findAll().flatMap(i-> documentToDto(i)).collectList();
    }

}
