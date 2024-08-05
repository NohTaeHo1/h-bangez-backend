package com.bangez.user.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class BrokerDto {
    private Long id;
    private String brokerName;
    private Long phone;
    private Long brokerageNum;
    private Long businessNum;
    private String companyName;
}
