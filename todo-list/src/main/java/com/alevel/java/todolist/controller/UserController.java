package com.alevel.java.todolist.controller;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.TodoStatus;
import com.alevel.java.todolist.entity.request.SaveRegularUserRequest;
import com.alevel.java.todolist.entity.request.SaveTodoRequest;
import com.alevel.java.todolist.entity.response.TodoResponse;
import com.alevel.java.todolist.entity.response.UserResponse;
import com.alevel.java.todolist.service.TodoListOperations;
import com.alevel.java.todolist.service.UserOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserOperations userOperations;

    private final TodoListOperations todoListOperations;

    public UserController(UserOperations userOperations, TodoListOperations todoListOperations) {
        this.userOperations = userOperations;
        this.todoListOperations = todoListOperations;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody SaveRegularUserRequest request) {
        var saveRequest = request.toSaveRequest();

        var user = userOperations.create(saveRequest);

        return ResponseEntity
                .created(URI.create("/users/" + user.getId()))
                .body(UserResponse.fromUser(user));
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Integer id) {
        var user = userOperations.getById(id);
        return UserResponse.fromUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody SaveRegularUserRequest request) {
        userOperations.update(id, request.toSaveRequest());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        userOperations.deleteById(id);
    }

    @GetMapping("/{id}/todos")
    public List<TodoResponse> getTodosByUser(@PathVariable Integer id,
                                             @RequestParam(required = false) TodoStatus status) {
        List<TodoList> todos = status != null
                ? todoListOperations.getAllByUserIdAndStatus(id, status)
                : userOperations.getById(id).getTodos();

        return todos.stream()
                .map(TodoResponse::fromTodo)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/todos")
    public ResponseEntity<TodoResponse> createTodo(@PathVariable Integer id,
                                                   @RequestBody SaveTodoRequest request) {
        var todo = todoListOperations.create(id, request);

        return ResponseEntity
                .created(URI.create("/todos/" + todo.getId()))
                .body(TodoResponse.fromTodo(todo));
    }

}
