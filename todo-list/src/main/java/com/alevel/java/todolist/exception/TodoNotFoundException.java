package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoNotFoundException extends ResponseStatusException {

    public TodoNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Todo with id " + id + " was not found");
    }

}
