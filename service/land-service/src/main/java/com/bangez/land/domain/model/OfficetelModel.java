package com.bangez.land.domain.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "officetels")
public class OfficetelModel {

    @Id
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
    private List<String> tagList; //List<String>?
    private String bildNm;
    private String town;
    private String roadAddress;
    private String address;
}