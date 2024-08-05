package com.bangez.gateway.router;

import com.bangez.gateway.domain.dto.LoginDto;
import com.bangez.gateway.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRouter {
        private final AuthService authService;

    //    @PostMapping("/login/local")
//    public Mono<ServerResponse> login(@RequestBody LoginDTO dto) {
//        return authService.localLogin(dto);
//    }
//
//    @PostMapping("/refresh")
//    public Mono<ServerResponse> refresh(@RequestHeader(name = "Authorization") String refreshToken) {
//        return authService.refresh(refreshToken);
//    }
//
//    @PostMapping("/logout")
//    public Mono<ServerResponse> logout(@RequestHeader(name = "Authorization") String refreshToken) {
//        return authService.logout(refreshToken);
//    }
    @Bean
    RouterFunction<ServerResponse> authRoutes() {
        return RouterFunctions.route()
                .POST("/auth/login/local", req -> req.bodyToMono(LoginDto.class).flatMap(authService::localLogin))
                .POST("/auth/refresh", req -> authService.refresh(req.headers().header("Authorization").get(0))) //로그아웃 시 compact JWT strings may not contain whitespace 에러 발생함.
                .POST("/auth/logout", req -> authService.logout(req.headers().header("Authorization").get(0)))
                .build();
    }
}