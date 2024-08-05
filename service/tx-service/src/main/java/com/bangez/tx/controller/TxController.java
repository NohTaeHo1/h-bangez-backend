package com.bangez.tx.controller;

import com.bangez.tx.domain.dto.TxDto;
import com.bangez.tx.service.impl.PointServiceImpl;
import com.bangez.tx.service.impl.TxServiceImpl;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TxController {

    private final TxServiceImpl txService;
    private final PointServiceImpl pointService;

    private IamportClient iamportClient;

    @Value("${imp.api.key}")
    private String apiKey;

    @Value("${imp.api.secretKey}")
    private String secretKey;

    @PostConstruct
    public void init() {
        this.iamportClient = new IamportClient(apiKey, secretKey);
    }

    @PostMapping("/add/{imp_uid}/{userId}")
    public IamportResponse<Payment> addIamport(@PathVariable("imp_uid") String imp_uid,
                                               @PathVariable("userId") Long userId) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd/HH:mm:ss");

        IamportResponse<Payment> payment = iamportClient.paymentByImpUid(imp_uid);

        TxDto tx = TxDto.builder()
                .impUid(payment.getResponse().getImpUid())
                .merchantUid(payment.getResponse().getMerchantUid())
                .propertyName(payment.getResponse().getName())
                .propertyAmount(Long.parseLong(payment.getResponse().getAmount().toString()))
                .buyerEmail(payment.getResponse().getBuyerEmail())
                .buyerName(payment.getResponse().getBuyerName())
                .buyerTel(payment.getResponse().getBuyerTel())
                .txDate(date.format(formatter))
                .userId(userId)
                .build();
        txService.saveTx(tx);
        pointService.savePoint(payment.getResponse().getAmount(), userId);

        return payment;
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<TxDto>> getTxList(@PathVariable("userId") Long id) {
        List<TxDto> txList = txService.getTxList();
        return ResponseEntity.ok(txList);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TxDto> getTxDetail(@PathVariable("id") Long id){
        log.info("디테일 메소드 id: {}", id);
        return ResponseEntity.ok(txService.getTxDetail(id));
    }


}
