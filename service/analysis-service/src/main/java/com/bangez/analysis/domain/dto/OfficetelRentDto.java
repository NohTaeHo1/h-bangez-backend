package com.bangez.analysis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficetelRentDto {

    private String officetelRentId ;
    private String address;
    private String builtYear;
    private String contractDate;
    private String floor;
    private String leaseTerm;
    private String legalCode;
    private Long monthlyRent;
    private Float netLeasableArea;
    private String officetelName;
    private Long securityDeposit;
    private String ward;
}
