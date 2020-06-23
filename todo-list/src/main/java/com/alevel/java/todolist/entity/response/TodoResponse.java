package com.alevel.java.todolist.entity.response;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.TodoStatus;

import java.util.UUID;

public class TodoResponse {

    private UUID id;

    private String text;

    private TodoStatus status;

    private Integer userId;

    public static TodoResponse fromTodo(TodoList todo) {
        return new TodoResponse(todo.getId(), todo.getText(), todo.getStatus(), todo.getUser().getId());
    }

    public TodoResponse() {
    }

    public TodoResponse(UUID id, String text, TodoStatus status, Integer userId) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
