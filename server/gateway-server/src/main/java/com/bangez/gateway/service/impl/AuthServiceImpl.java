package com.bangez.gateway.service.impl;

import com.bangez.gateway.domain.dto.LoginDto;
import com.bangez.gateway.domain.model.PrincipalUserDetails;
import com.bangez.gateway.service.AuthService;
import com.bangez.gateway.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final WebClient webClient;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Mono<ServerResponse> localLogin(LoginDto dto) {
        return Mono.just(dto)
                .log()
                .flatMap(i ->
                        webClient.post()
                                .uri("lb://user-service/auth/login/local")
                                .accept(MediaType.APPLICATION_JSON)
                                .bodyValue(i)
                                .retrieve()
                                .bodyToMono(PrincipalUserDetails.class)
                )
                .flatMap(i ->
                        jwtTokenProvider.generateToken(i, false)
                                .flatMap(accessToken ->
                                        jwtTokenProvider.generateToken(i, true)
                                                .flatMap(refreshToken ->
                                                        ServerResponse.ok()
                                                                .cookie(
                                                                        ResponseCookie.from("accessToken")
                                                                                .value(accessToken)
                                                                                .maxAge(jwtTokenProvider.getAccessTokenExpired())
                                                                                .path("/")
                                                                                .sameSite("None")
                                                                                .secure(true)
                                                                                .httpOnly(false)
                                                                                .build()
                                                                )
                                                                .cookie(
                                                                        ResponseCookie.from("refreshToken")
                                                                                .value(refreshToken)
                                                                                .maxAge(jwtTokenProvider.getRefreshTokenExpired())
                                                                                .path("/")
                                                                                .sameSite("None")
                                                                                .secure(true)
                                                                                .httpOnly(false)
                                                                                .build()
                                                                )
                                                                .bodyValue(Boolean.TRUE)
                                                )
                                )
                )
                ;


    }

    @Override
    public Mono<ServerResponse> refresh(String refreshToken) {
        return Mono.just(refreshToken)
                .flatMap(i -> Mono.just(jwtTokenProvider.removeBearer(refreshToken)))
                .filter(i -> jwtTokenProvider.isTokenValid(refreshToken, true))
                .filterWhen(i -> jwtTokenProvider.isTokenInRedis(refreshToken))
                .flatMap(i -> Mono.just(jwtTokenProvider.extractPrincipalUserDetails(refreshToken)))
                .flatMap(i -> jwtTokenProvider.generateToken(i, false))
                .flatMap(accessToken ->
                        ServerResponse.ok()
                                .cookie(
                                        ResponseCookie.from("accessToken")
                                                .value(accessToken)
                                                .maxAge(jwtTokenProvider.getAccessTokenExpired())
                                                .path("/")
                                                // .httpOnly(true)
                                                .build()
                                )
                                .build()
                );
    }

    @Override
    public Mono<ServerResponse> logout(String refreshToken) {
        log.info("로그아웃 서비스");
        return Mono.just(refreshToken)
                .flatMap(i -> Mono.just(jwtTokenProvider.removeBearer(refreshToken)))
                .filter(i -> jwtTokenProvider.isTokenValid(refreshToken, true))
                .filterWhen(i -> jwtTokenProvider.isTokenInRedis(refreshToken))
                .filterWhen(i -> jwtTokenProvider.removeTokenInRedis(refreshToken))
                .flatMap(i -> ServerResponse.ok().build());
    }

}