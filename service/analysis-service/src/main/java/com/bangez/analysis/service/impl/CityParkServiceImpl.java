package com.bangez.analysis.service.impl;
import com.bangez.analysis.domain.dto.CityParkDto;
import com.bangez.analysis.repository.CityParkRepository;
import com.bangez.analysis.service.CityParkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityParkServiceImpl implements CityParkService{

    private final CityParkRepository repository;

    @Override
    public Mono<List<CityParkDto>> findAll(){
        return repository.findAll().flatMap(this::documentToDto).collectList();
    }
    
}
