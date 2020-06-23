package com.alevel.java.todolist.exception;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends TodoListException {

    public RoleNotFoundException(String name) {
        super(HttpStatus.NOT_FOUND, "Role " + name + " not found");
    }

}
