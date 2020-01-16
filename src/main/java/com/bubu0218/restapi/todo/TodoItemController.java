package com.bubu0218.restapi.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 배포서버
 *
 * http://133.130.57.24:8013/restfulServer/todo/
 * post body raw json
 * {"title":"할꺼..." , "done":false}
 *
 * 로컬서버
 * http://localhost:8080/todo/
 *
 */

@RestController
@RequestMapping("/todo")
public class TodoItemController {

    @Autowired
    private TodoItemService toDoItemService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody TodoItemResponse get(@PathVariable(value="id") String id) {
        List<String> errors = new ArrayList<>();
        TodoItem toDoItem = null;
        try {
            toDoItem = toDoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return TodoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<TodoItemResponse> getAll() {
        List<String> errors = new ArrayList<>();
        List<TodoItem> toDoItems = toDoItemService.getAll();
        List<TodoItemResponse> toDoItemResponses = new ArrayList<>();
        toDoItems.stream().forEach(toDoItem -> {
            toDoItemResponses.add(TodoItemAdapter.toToDoItemResponse(toDoItem, errors));
        });
        return toDoItemResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody TodoItemResponse create(@RequestBody final TodoItemRequest toDoItemRequest) {
        List<String> errors = new ArrayList<>();
        TodoItem toDoItem = TodoItemAdapter.toTodoItem(toDoItemRequest);
        System.out.println(toDoItemRequest.getTitle());
        try {
            toDoItem = toDoItemService.create(toDoItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return TodoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }
}