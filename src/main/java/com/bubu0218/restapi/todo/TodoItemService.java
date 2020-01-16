package com.bubu0218.restapi.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItem get(final String id) {
        // do id validation
        return  todoItemRepository.findById(id).orElse(null);
    }

    public TodoItem create(final TodoItem todoItem) {
        if(todoItem == null) {
            throw new NullPointerException("To Do Item cannot be null.");
        }
        return todoItemRepository.insert(todoItem);
    }

    public List<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }
}
