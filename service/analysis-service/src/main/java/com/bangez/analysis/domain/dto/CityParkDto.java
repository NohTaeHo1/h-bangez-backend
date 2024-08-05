package com.bangez.analysis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityParkDto {
    private String cityParkId;
    private String address;
    private Float area;
    private String latitude;
    private String longitude;
    private String parkName;
    private String parkType;
}
