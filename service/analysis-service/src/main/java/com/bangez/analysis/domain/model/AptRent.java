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
@Document("aptRents")
public class AptRent {
    @Id
    private String aptRentId ;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "apt_name")
    @Field("apt_name")
    private String aptName;

    @CsvBindByName(column = "built_year")
    @Field("built_year")
    private String builtYear;

    @CsvBindByName(column = "contract_date")
    @Field("contract_date")
    private String contractDate;

    @CsvBindByName(column = "floor")
    private String floor;

    @CsvBindByName(column = "lease_term")
    @Field("lease_term")
    private String leaseTerm;

    @CsvBindByName(column = "legal_code")
    @Field("legal_code")
    private String legalCode;

    @CsvBindByName(column = "monthly_rent")
    @Field("monthly_rent")
    private Long monthlyRent;

    @CsvBindByName(column = "net_leasable_area")
    @Field("net_leasable_area")
    private Float netLeasableArea;

    @CsvBindByName(column = "security_deposit")
    @Field("security_deposit")
    private Long securityDeposit;

    @CsvBindByName(column = "ward")
    private String ward;
   

}