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
public class ApartmentDto {

    private String id;
    private long atclNo ; //네이버 번호(사용x)
    private String atclNm; //아파트/상가 명
    private String rletTpNm; //상가 구분
    private String tradTpNm; //매매/전세/월세 구분
    private String flrInfo; //층수(물건층/전체층)
    private int prc; //가격
    private long rentPrc; //월세
    private String hanPrc; //보증금
    private double spc1; //계약면적(m2)
    private double spc2; //전용면적(m2)
    private String direction; //집 방향
    private String atclCfmYmd; //date?
    private String lat; //위도
    private String lng; //경도
    private String atclFetrDesc; //설명
    private List<String> tagList; //[기타 정보]
    private String bildNm; //동수 ex) 101동
    private String town; //동 이름
    private String roadAddress; //도로명 주소
    private String address; //지번 주소
    private String image; //이미지
    private String imageTwo; //이미지
}