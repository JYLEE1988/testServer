package com.bubu0218.restapi;

import java.util.List;

public class TodoItemAdapter {
    public static TodoItemResponse toToDoItemResponse(final TodoItem toDoItem, final List<String> errors) {
        return TodoItemResponse.builder().todoItem(toDoItem).errors(errors).build();
    }


}
