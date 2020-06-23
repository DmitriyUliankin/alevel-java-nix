package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends TodoListException {

    public UserNotFoundException(String username) {
        super(HttpStatus.NOT_FOUND, "User " + username + " not found");
    }

    public UserNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "User with id " + id + " not found");
    }

}
