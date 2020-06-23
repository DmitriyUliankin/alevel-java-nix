package com.alevel.java.todolist.entity.request;

import com.alevel.java.todolist.entity.TodoStatus;

public class SetTodoStatusRequest {

    private TodoStatus status;

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

}
