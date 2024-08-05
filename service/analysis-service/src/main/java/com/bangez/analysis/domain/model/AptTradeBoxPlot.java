package com.bangez.analysis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AptTradeBoxPlot {

    private Double min;
    private Double max;
    private Double q1; // 1사분위수
    private Double median; // 중앙값
    private Double q3; // 3사분위수

}
