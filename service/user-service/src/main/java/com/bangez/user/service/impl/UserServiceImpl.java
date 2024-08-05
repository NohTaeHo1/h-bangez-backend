package com.bangez.user.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.dto.UserDto;
import com.bangez.user.repository.UserRepository;
import com.bangez.user.service.UserService;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Messenger save(UserDto t){
        entityToDTO((repository.save(dtoToEntity(t))));
        return Messenger.builder().message("True").build();
    }

    @Override
    public UserDto getDetail(Long userId) {
        return repository.findById(userId)
                .map(this::entityToDTO)
                .orElse(null);
    }

}