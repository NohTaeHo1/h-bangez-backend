package com.bangez.chat.domain.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chats")
public class ChatModel {
    @Id
    private String id;
    private String chatRoomId;
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime timeStamp;

    private boolean read; //메시지 상태("안읽음", "읽음") 알림을 위한 필드 default false
}
