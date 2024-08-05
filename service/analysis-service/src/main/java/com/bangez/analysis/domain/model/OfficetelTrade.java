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
@Document("officetelTrades")
public class OfficetelTrade {
    @Id
    private String officetelTradeId ;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "built_year")
    @Field("built_year")
    private String builtYear;

    @CsvBindByName(column = "contract_date")
    @Field("contract_date")
    private String contractDate;

    @CsvBindByName(column = "floor")
    private String floor;

    @CsvBindByName(column = "legal_code")
    @Field("legal_code")
    private String legalCode;

    @CsvBindByName(column = "net_leasable_area")
    @Field("net_leasable_area")
    private Float netLeasableArea;

    @CsvBindByName(column = "officetel_name")
    @Field("officetel_name")
    private String officetelName;

    @CsvBindByName(column = "price_per_area")
    @Field("price_per_area")
    private Float pricePerArea;

    @CsvBindByName(column = "trade_price")
    @Field("trade_price")
    private Long tradePrice;

    @CsvBindByName(column = "ward")
    private String ward;

}
// builtYear officetelName transactionAmount contractDate area floor address legalCode
