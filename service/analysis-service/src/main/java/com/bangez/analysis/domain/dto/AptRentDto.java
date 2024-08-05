package com.bangez.analysis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AptRentDto {

    private String aptRentId;
    private String address;
    private String aptName;
    private String builtYear;
    private String contractDate;
    private String floor;
    private String leaseTerm;
    private String legalCode;
    private Long monthlyRent;
    private Float netLeasableArea;
    private Long securityDeposit;
    private String ward;

}