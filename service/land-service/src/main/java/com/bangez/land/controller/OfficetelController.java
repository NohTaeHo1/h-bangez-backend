package com.bangez.land.controller;

import com.bangez.land.domain.dto.OfficetelDto;
import com.bangez.land.service.OfficetelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/officetels")
public class OfficetelController {

    private final OfficetelService officetelService;

    @Autowired
    public OfficetelController(OfficetelService officetelService) {
        this.officetelService = officetelService;
    }

    @GetMapping
    public Flux<OfficetelDto> getAllOfficetels() {
        return officetelService.getAllOfficetels();
    }

    @GetMapping("/{id}")
    public Mono<OfficetelDto> getOfficetelById(@PathVariable String id) {
        return officetelService.getOfficetelById(id);
    }

    @PostMapping
    public Mono<OfficetelDto> createOfficetel(@RequestBody OfficetelDto officetelDTO) {
        return officetelService.createOfficetel(officetelDTO);
    }

    @PutMapping("/{id}")
    public Mono<OfficetelDto> updateOfficetel(@PathVariable String id, @RequestBody OfficetelDto officetelDTO) {
        return officetelService.updateOfficetel(id, officetelDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOfficetel(@PathVariable String id) {
        return officetelService.deleteOfficetel(id);
    }
}