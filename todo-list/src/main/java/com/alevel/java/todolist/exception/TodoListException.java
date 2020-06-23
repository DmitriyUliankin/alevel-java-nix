package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoListException extends ResponseStatusException {

    public TodoListException(HttpStatus status) {
        super(status);
    }

    public TodoListException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public TodoListException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

}
