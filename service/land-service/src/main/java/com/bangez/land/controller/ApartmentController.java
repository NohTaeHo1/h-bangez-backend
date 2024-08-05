package com.bangez.land.controller;

import com.bangez.land.domain.dto.ApartmentDto;
import com.bangez.land.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {


    private final ApartmentService apartmentService;

    @GetMapping
    public Flux<ApartmentDto> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/{id}")
    public Mono<ApartmentDto> getApartmentById(@PathVariable String id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping
    public Mono<ApartmentDto> createApartment(@RequestBody ApartmentDto apartmentDTO) {
        return apartmentService.createApartment(apartmentDTO);
    }

    @PutMapping("/{id}")
    public Mono<ApartmentDto> updateApartment(@PathVariable String id, @RequestBody ApartmentDto apartmentDTO) {
        return apartmentService.updateApartment(id, apartmentDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteApartment(@PathVariable String id) {
        return apartmentService.deleteApartment(id);
    }

    @GetMapping("/search")
    public Flux<ApartmentDto> searchApartments(@RequestParam String tradTpNm, @RequestParam int minPrice, @RequestParam int maxPrice) {
        return apartmentService.searchApartments(tradTpNm, minPrice, maxPrice);
    }

    @GetMapping("/searchByPrice")
    public Flux<ApartmentDto> searchApartmentsByPrice(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return apartmentService.searchApartmentsByPrice(minPrice, maxPrice);
    }

    @GetMapping("/filter")
    public Flux<ApartmentDto> getFilteredApartments(
            @RequestParam(required = false) String rletTpNm,
            @RequestParam(required = false) String tradTpNm,
            @RequestParam(required = false) Integer minPrc,
            @RequestParam(required = false) Integer maxPrc,
            @RequestParam(required = false) Integer minSpc1,
            @RequestParam(required = false) Integer maxSpc1,
            @RequestParam(required = false) String town) {
        return apartmentService.getFilteredApartments(rletTpNm, tradTpNm, minPrc, maxPrc, minSpc1, maxSpc1, town);
    }



}









