package com.alevel.java.todolist.controller;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.changereq.ChangeRequest;
import com.alevel.java.todolist.exception.TodoNotFoundException;
import com.alevel.java.todolist.service.TodoListOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo-list")
public class TodoListController {

    private final TodoListOperations todoListOperations;

    public TodoListController(TodoListOperations todoListOperations) {
        this.todoListOperations = todoListOperations;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getById(@PathVariable Long id) {
        return todoListOperations.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @GetMapping(path = "/all")
    public List<TodoList> getAll() {
        return todoListOperations.getAllTodo();
    }

    @GetMapping(path = "/uncompleted")
    public List<TodoList> getAllNotDone() {
        return todoListOperations.getAllNotDone();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList create(@RequestBody ChangeRequest request) {
        return todoListOperations.create(request);
    }

    @DeleteMapping("/{id}")
    public TodoList deleteById(@PathVariable Long id) {
        return todoListOperations.deleteById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ChangeRequest request) {
        todoListOperations.update(id, request);
    }


}
