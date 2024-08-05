package com.bangez.land.service.impl;

import com.bangez.land.domain.dto.ApartmentDto;
import com.bangez.land.domain.mapper.ApartmentMapper;
import com.bangez.land.domain.model.ApartmentModel;
import com.bangez.land.repository.ApartmentRepository;
import com.bangez.land.service.ApartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentMapper apartmentMapper;
    private final ApartmentRepository apartmentRepository;
    
    public ApartmentServiceImpl(ApartmentMapper apartmentMapper, ApartmentRepository apartmentRepository) {
        this.apartmentMapper = apartmentMapper;
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public Flux<ApartmentDto> getAllApartments() {
        return apartmentRepository.findAll()
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Mono<ApartmentDto> getApartmentById(String id) {
        return apartmentRepository.findById(id)
                .map(apartmentMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Apartment not found")));
    }
    @Override
    public Mono<ApartmentDto> createApartment(ApartmentDto apartmentDTO) {
        ApartmentModel model = apartmentMapper.toModel(apartmentDTO);
        return apartmentRepository.save(model)
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Mono<ApartmentDto> updateApartment(String id, ApartmentDto apartmentDTO) {
        return apartmentRepository.findById(id)
                .flatMap(existingApartment -> {
                    existingApartment.setAtclNo(apartmentDTO.getAtclNo());
                    existingApartment.setAtclNm(apartmentDTO.getAtclNm());
                    existingApartment.setRletTpNm(apartmentDTO.getRletTpNm());
                    existingApartment.setTradTpNm(apartmentDTO.getTradTpNm());
                    existingApartment.setFlrInfo(apartmentDTO.getFlrInfo());
                    existingApartment.setPrc(apartmentDTO.getPrc());
                    existingApartment.setRentPrc(apartmentDTO.getRentPrc());
                    existingApartment.setHanPrc(apartmentDTO.getHanPrc());
                    existingApartment.setSpc1(apartmentDTO.getSpc1());
                    existingApartment.setSpc2(apartmentDTO.getSpc2());
                    existingApartment.setDirection(apartmentDTO.getDirection());
                    existingApartment.setAtclCfmYmd(apartmentDTO.getAtclCfmYmd());
                    existingApartment.setLat(apartmentDTO.getLat());
                    existingApartment.setLng(apartmentDTO.getLng());
                    existingApartment.setAtclFetrDesc(apartmentDTO.getAtclFetrDesc());
                    existingApartment.setTagList(apartmentDTO.getTagList());
                    existingApartment.setBildNm(apartmentDTO.getBildNm());
                    existingApartment.setTown(apartmentDTO.getTown());
                    existingApartment.setRoadAddress(apartmentDTO.getRoadAddress());
                    existingApartment.setAddress(apartmentDTO.getAddress());
                    return apartmentRepository.save(existingApartment);
                })
                .map(apartmentMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Apartment not found")));
    }
    @Override
    public Mono<Void> deleteApartment(String id) {
        return apartmentRepository.deleteById(id)
                .onErrorResume(e -> Mono.error(new IllegalArgumentException("Failed to delete apartment", e)));
    }
    @Override
    public Flux<ApartmentDto> searchApartments(String tradTpNm, int minPrice, int maxPrice) {
        return apartmentRepository.findByTradTpNmAndPrcBetween(tradTpNm, minPrice, maxPrice)
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Flux<ApartmentDto> searchApartmentsByPrice(int minPrice, int maxPrice) {
        return apartmentRepository.findByPrcBetween(minPrice, maxPrice)
                .map(apartmentMapper::toDTO);
    }

    @Override
    public Flux<ApartmentDto> getFilteredApartments(String rletTpNm, String tradTpNm, Integer minPrc, Integer maxPrc, Integer minSpc1, Integer maxSpc1, String town) {
        log.info("Fetching filtered apartments with criteria - rletTpNm: {}, tradTpNm: {}, minPrc: {}, maxPrc: {}, minSpc1: {}, maxSpc1: {}, town: {}",
                rletTpNm, tradTpNm, minPrc, maxPrc, minSpc1, maxSpc1, town);
        return apartmentRepository.findByCriteria(rletTpNm, tradTpNm, minPrc, maxPrc, minSpc1, maxSpc1, town)
                .map(apartmentMapper::toDTO);
    }
}