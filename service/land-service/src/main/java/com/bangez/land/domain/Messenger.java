package com.bangez.land.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Messenger {
    private String message;
    private Object data; // 제네릭 객체
    private String accessToken;
    private String refreshToken;
    private long accessTokenExpire;
    private long refreshTokenExpire;

}