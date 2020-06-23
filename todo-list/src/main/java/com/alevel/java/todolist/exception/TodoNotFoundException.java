package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class TodoNotFoundException extends ResponseStatusException {

    public TodoNotFoundException(UUID id) {
        super(HttpStatus.NOT_FOUND, "Todo item with id " + id + " not found");
    }

}
