package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends TodoListException {

    public UserAlreadyExistsException(String username) {
        super(HttpStatus.BAD_REQUEST, "User " + username + " already exists");
    }

}
