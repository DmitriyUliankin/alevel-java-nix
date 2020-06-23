package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.User;
import com.alevel.java.todolist.entity.request.SaveUserRequest;

public interface UserOperations {

    User create(SaveUserRequest request);

    void update(Integer id, SaveUserRequest request);

    User getById(Integer id);

    void deleteById(Integer id);

}
