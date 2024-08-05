package com.bangez.analysis.domain.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("cityParks")
public class CityPark {
    @Id
    private String cityParkId;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "area")
    private Float area;

    @CsvBindByName(column = "latitude")
    private String latitude;

    @CsvBindByName(column = "longitude")
    private String longitude;

    @CsvBindByName(column = "park_name")
    @Field("park_name")
    private String parkName;

    @CsvBindByName(column = "park_type")
    @Field("park_type")
    private String parkType;

}

