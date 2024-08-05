package com.bangez.tx.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "transactions")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
