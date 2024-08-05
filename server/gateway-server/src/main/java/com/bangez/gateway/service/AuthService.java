package com.bangez.gateway.service;

import com.bangez.gateway.domain.dto.LoginDto;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<ServerResponse> localLogin(LoginDto dto);
    Mono<ServerResponse> refresh(String refreshToken);
    Mono<ServerResponse> logout(String refreshToken);
}