package com.bubu0218.restapi;

import java.util.List;

public class TodoItemAdapter {
    public static TodoItemResponse toToDoItemResponse(final TodoItem toDoItem, final List<String> errors) {
        return TodoItemResponse.builder().todoItem(toDoItem).errors(errors).build();
    }

    public static TodoItem toTodoItem(final TodoItemRequest toDoItemRequest) {
        if(toDoItemRequest == null) {
            return null;
        }
        return TodoItem.builder()
                .title(toDoItemRequest.getTitle())
                .done(toDoItemRequest.isDone())
                .build();
    }

}
