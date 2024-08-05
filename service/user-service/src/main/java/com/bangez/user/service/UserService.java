package com.bangez.user.service;

import com.bangez.user.domain.dto.Messenger;
import com.bangez.user.domain.dto.UserDto;
import com.bangez.user.domain.model.User;

public interface UserService {

    default UserDto entityToDTO(User user){
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .passwordConfirm(user.getPasswordConfirm())
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

    default User dtoToEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .passwordConfirm(dto.getPasswordConfirm())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }

    Messenger save(UserDto t);

    UserDto getDetail(Long userId);
}