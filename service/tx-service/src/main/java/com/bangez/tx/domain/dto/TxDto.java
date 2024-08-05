package com.bangez.tx.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxDto {
    private Long txId;

    private String impUid;
    private String merchantUid;
    private String propertyName;
    private Long propertyAmount;
    private String buyerEmail;
    private String buyerName;
    private String buyerTel;

    private String txDate;

    private Long userId;
    private Long apartmentId;
    private Long officetelId;
}
