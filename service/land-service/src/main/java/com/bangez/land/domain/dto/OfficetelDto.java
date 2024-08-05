package com.bangez.land.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfficetelDto {

    private String id;
    private long atclNo ;
    private String atclNm;
    private String rletTpNm;
    private String tradTpNm;
    private String flrInfo;
    private long prc;
    private long rentPrc;
    private String hanPrc;
    private String spc1;
    private String spc2;
    private String direction;
    private String atclCfmYmd; //date?
    private String lat;
    private String lng;
    private String atclFetrDesc;
    private List<String> tagList; 
    private String bildNm;
    private String town;
    private String roadAddress;
    private String address;
}