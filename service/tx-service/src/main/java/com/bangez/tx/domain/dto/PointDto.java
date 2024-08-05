package com.bangez.tx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointDto {
    private Long pointId;

    private int point;

    private String lastChargeDate;

    private Long userId;
}
