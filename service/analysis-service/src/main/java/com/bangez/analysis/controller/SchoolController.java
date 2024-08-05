package com.bangez.analysis.controller;

import com.bangez.analysis.domain.dto.SchoolDto;
import com.bangez.analysis.service.impl.SchoolServiceImpl;
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
@RequestMapping(path = "/api/school")
public class SchoolController {
    private final SchoolServiceImpl service;

    @GetMapping("/statistics")
    public Mono<List<SchoolDto>> findAll(){
        return service.findAll();
    }
}