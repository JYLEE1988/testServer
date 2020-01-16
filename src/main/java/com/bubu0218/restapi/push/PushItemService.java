package com.bubu0218.restapi.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushItemService {

    @Autowired
    private PushItemRepository pushItemRepository;

    public PushItem get(final String token) {
        // do id validation
        return  pushItemRepository.findById(token).orElse(null);
    }

    public PushItem create(final PushItem pushItem) {
        if(pushItem == null) {
            throw new NullPointerException("To Do Item cannot be null.");
        }
        return pushItemRepository.insert(pushItem);
    }

    public List<PushItem> getAll() {
        return pushItemRepository.findAll();
    }
}
