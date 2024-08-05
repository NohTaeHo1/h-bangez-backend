package com.bangez.chat.service;

import com.bangez.chat.domain.dto.Messenger;
import com.bangez.chat.domain.dto.RoomDto;
import com.bangez.chat.domain.model.RoomModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {
    Mono<RoomDto> openRoom(String userId, String receiverId);

    Flux<RoomDto> getRoomList(String userId);

    Mono<Messenger> deleteRoom(String roomId);

    default RoomDto convertToDto(RoomModel roomModel){
        return RoomDto.builder()
                .id(roomModel.getId())
                .roomTitle(roomModel.getRoomTitle())
                .senderId(roomModel.getSenderId())
                .receiverId(roomModel.getReceiverId())
                .createDate(roomModel.getCreateDate())
                .build();
    }
}

