package com.bangez.chat.service;
import com.bangez.chat.domain.dto.ChatDto;
import com.bangez.chat.domain.dto.Messenger;
import com.bangez.chat.domain.model.ChatModel;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface ChatService {
    Flux<ServerSentEvent<ChatDto>> connectChat(String roomId) ;

    Mono<ChatDto> saveMessage(ChatDto chatDto);

    Mono<Messenger> markMessageRead(String roomId, String userId);

    Flux<ServerSentEvent<ChatDto>> connectionNotification(String userId);

    default ChatDto convertToDto(ChatModel chatModel) {
        return ChatDto.builder()
                .id(chatModel.getId())
                .chatRoomId(chatModel.getChatRoomId())
                .senderId(chatModel.getSenderId())
                .receiverId(chatModel.getReceiverId())
                .message(chatModel.getMessage())
                .timeStamp(chatModel.getTimeStamp())
                .read(chatModel.isRead())
                .build();
    }

    default ChatModel convertToEntity(ChatDto chatDto) {
        return ChatModel.builder()
                .id(chatDto.getId())
                .chatRoomId(chatDto.getChatRoomId())
                .senderId(chatDto.getSenderId())
                .receiverId(chatDto.getReceiverId())
                .message(chatDto.getMessage())
                .timeStamp(chatDto.getTimeStamp())
                .read(chatDto.isRead())
                .build();
    }
    
}
