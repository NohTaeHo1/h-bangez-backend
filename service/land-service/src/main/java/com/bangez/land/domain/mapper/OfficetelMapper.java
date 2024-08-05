package com.bangez.land.domain.mapper;

import com.bangez.land.domain.dto.OfficetelDto;
import com.bangez.land.domain.model.OfficetelModel;
import org.springframework.stereotype.Component;

@Component
public class OfficetelMapper {
    public OfficetelModel toModel(OfficetelDto dto) {
        return OfficetelModel.builder()
                .id(dto.getId())
                .atclNo(dto.getAtclNo())
                .atclNm(dto.getAtclNm())
                .rletTpNm(dto.getRletTpNm())
                .tradTpNm(dto.getTradTpNm())
                .flrInfo(dto.getFlrInfo())
                .prc(dto.getPrc())
                .rentPrc(dto.getRentPrc())
                .hanPrc(dto.getHanPrc())
                .spc1(dto.getSpc1())
                .spc2(dto.getSpc2())
                .direction(dto.getDirection())
                .atclCfmYmd(dto.getAtclCfmYmd())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .atclFetrDesc(dto.getAtclFetrDesc())
                .tagList(dto.getTagList())
                .bildNm(dto.getBildNm())
                .town(dto.getTown())
                .roadAddress(dto.getRoadAddress())
                .address(dto.getAddress())
                .build();
    }
    public OfficetelDto toDTO(OfficetelModel model) {
        return OfficetelDto.builder()
                .id(model.getId())
                .atclNo(model.getAtclNo())
                .atclNm(model.getAtclNm())
                .rletTpNm(model.getRletTpNm())
                .tradTpNm(model.getTradTpNm())
                .flrInfo(model.getFlrInfo())
                .prc(model.getPrc())
                .rentPrc(model.getRentPrc())
                .hanPrc(model.getHanPrc())
                .spc1(model.getSpc1())
                .spc2(model.getSpc2())
                .direction(model.getDirection())
                .atclCfmYmd(model.getAtclCfmYmd())
                .lat(model.getLat())
                .lng(model.getLng())
                .atclFetrDesc(model.getAtclFetrDesc())
                .tagList(model.getTagList())
                .bildNm(model.getBildNm())
                .town(model.getTown())
                .roadAddress(model.getRoadAddress())
                .address(model.getAddress())
                .build();
    }
}