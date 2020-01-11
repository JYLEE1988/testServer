package com.bubu0218.restapi;

import org.springframework.stereotype.Service;

@Service
public class TodoItemService {

    public TodoItem get(final String id){
        return TodoItem.builder().title("test").build();
    }
}
