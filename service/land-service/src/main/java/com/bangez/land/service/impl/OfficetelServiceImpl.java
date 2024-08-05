package com.bangez.land.service.impl;

import com.bangez.land.domain.dto.OfficetelDto;
import com.bangez.land.domain.mapper.OfficetelMapper;
import com.bangez.land.domain.model.OfficetelModel;
import com.bangez.land.repository.OfficetelRepository;
import com.bangez.land.service.OfficetelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OfficetelServiceImpl implements OfficetelService {

    private final OfficetelMapper officetelMapper;
    private final OfficetelRepository officetelRepository;

    @Autowired
    public OfficetelServiceImpl(OfficetelMapper officetelMapper, OfficetelRepository officetelRepository) {
        this.officetelMapper = officetelMapper;
        this.officetelRepository = officetelRepository;
    }

    @Override
    public Flux<OfficetelDto> getAllOfficetels() {
        return officetelRepository.findAll()
                .map(officetelMapper::toDTO);
    }

    @Override
    public Mono<OfficetelDto> getOfficetelById(String id) {
        return officetelRepository.findById(id)
                .map(officetelMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Officetel not found")));
    }

    @Override
    public Mono<OfficetelDto> createOfficetel(OfficetelDto officetelDTO) {
        OfficetelModel model = officetelMapper.toModel(officetelDTO);
        return officetelRepository.save(model)
                .map(officetelMapper::toDTO);
    }

    @Override
    public Mono<OfficetelDto> updateOfficetel(String id, OfficetelDto officetelDTO) {
        return officetelRepository.findById(id)
                .flatMap(existingOfficetel -> {
                    existingOfficetel.setAtclNo(officetelDTO.getAtclNo());
                    existingOfficetel.setAtclNm(officetelDTO.getAtclNm());
                    existingOfficetel.setRletTpNm(officetelDTO.getRletTpNm());
                    existingOfficetel.setTradTpNm(officetelDTO.getTradTpNm());
                    existingOfficetel.setFlrInfo(officetelDTO.getFlrInfo());
                    existingOfficetel.setPrc(officetelDTO.getPrc());
                    existingOfficetel.setRentPrc(officetelDTO.getRentPrc());
                    existingOfficetel.setHanPrc(officetelDTO.getHanPrc());
                    existingOfficetel.setSpc1(officetelDTO.getSpc1());
                    existingOfficetel.setSpc2(officetelDTO.getSpc2());
                    existingOfficetel.setDirection(officetelDTO.getDirection());
                    existingOfficetel.setAtclCfmYmd(officetelDTO.getAtclCfmYmd());
                    existingOfficetel.setLat(officetelDTO.getLat());
                    existingOfficetel.setLng(officetelDTO.getLng());
                    existingOfficetel.setAtclFetrDesc(officetelDTO.getAtclFetrDesc());
                    existingOfficetel.setTagList(officetelDTO.getTagList());
                    existingOfficetel.setBildNm(officetelDTO.getBildNm());
                    existingOfficetel.setTown(officetelDTO.getTown());
                    existingOfficetel.setRoadAddress(officetelDTO.getRoadAddress());
                    existingOfficetel.setAddress(officetelDTO.getAddress());
                    return officetelRepository.save(existingOfficetel);
                })
                .map(officetelMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Officetel not found")));
    }

    @Override
    public Mono<Void> deleteOfficetel(String id) {
        return officetelRepository.deleteById(id)
                .onErrorResume(e -> Mono.error(new IllegalArgumentException("Failed to delete officetel", e)));
    }
}