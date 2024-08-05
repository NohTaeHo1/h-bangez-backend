package com.bangez.user.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.dto.UserDto;
import com.bangez.user.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;

    @PostMapping("/add")
    public ResponseEntity<Messenger> save(@RequestBody UserDto dto){
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/detail/{userId}")
    public ResponseEntity<UserDto> getDetail(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(service.getDetail(userId));
    }

}