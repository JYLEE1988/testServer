package com.bubu0218.restapi.push;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PushItemRepository extends MongoRepository<PushItem, String> {
    List<PushItem> findByToken(String token);
    List<PushItem> findByDeviceId(String deviceId);
}
