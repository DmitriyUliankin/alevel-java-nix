package com.alevel.java.todolist.controller;

import com.alevel.java.todolist.entity.request.SaveTodoRequest;
import com.alevel.java.todolist.entity.request.SetTodoStatusRequest;
import com.alevel.java.todolist.entity.response.TodoResponse;
import com.alevel.java.todolist.service.TodoListOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoListController {

    private final TodoListOperations todoListOperations;

    public TodoListController(TodoListOperations todoListOperations) {
        this.todoListOperations = todoListOperations;
    }

    @GetMapping("/{id}")
    public TodoResponse getById(@PathVariable UUID id) {
        var todo = todoListOperations.getById(id);
        return TodoResponse.fromTodo(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id, @RequestBody SaveTodoRequest request) {
        todoListOperations.update(id, request);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable UUID id, @RequestBody SetTodoStatusRequest request) {
        todoListOperations.updateStatus(id, request.getStatus());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        todoListOperations.deleteById(id);
    }

}
