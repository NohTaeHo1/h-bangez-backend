package com.bangez.chat.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bangez.chat.domain.model.RoomModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RoomRepository extends ReactiveMongoRepository<RoomModel,String>{
    Mono<RoomModel> getRoomModelBySenderIdAndReceiverId(String userId, String receiverId);

    Flux<RoomModel> findBySenderIdOrReceiverId(String senderId, String receiverId);
}
