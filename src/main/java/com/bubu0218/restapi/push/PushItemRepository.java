package com.bubu0218.restapi.push;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PushItemRepository extends MongoRepository<PushItem, String> {
}
