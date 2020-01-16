package com.bubu0218.restapi.todo;

import com.bubu0218.restapi.ApiResponse;
import lombok.Builder;

import java.util.List;

public class TodoItemResponse extends ApiResponse<TodoItem> {

    @Builder
    public TodoItemResponse(final TodoItem todoItem, final List<String> errors) {
        super(todoItem);
        this.setErrors(errors);
    }
}


