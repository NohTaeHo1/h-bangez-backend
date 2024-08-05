package com.bangez.analysis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AptTradeDto {

    private String aptTradeId;
    private String address;
    private String aptName;
    private String builtYear;
    private String contractDate;
    private String floor;
    private String legalCode;
    private Float netLeasableArea;
    private Float pricePerArea;
    private Long tradePrice;
    private String ward;
}