package com.alevel.java.todolist.entity.request;

import com.alevel.java.todolist.entity.TodoStatus;

public class SaveTodoRequest {

    private String text;

    private TodoStatus status;

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

}
