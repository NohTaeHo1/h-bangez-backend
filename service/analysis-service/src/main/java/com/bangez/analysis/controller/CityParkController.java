package com.bangez.analysis.controller;
import com.bangez.analysis.domain.dto.CityParkDto;
import com.bangez.analysis.service.impl.CityParkServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/city-park")
public class CityParkController {
    private final CityParkServiceImpl service;

    @GetMapping(path = "/statistics")
    public Mono<List<CityParkDto>> findAll(){
        return service.findAll();
    }
}
