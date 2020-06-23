package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.TodoStatus;
import com.alevel.java.todolist.entity.request.SaveTodoRequest;

import java.util.List;
import java.util.UUID;

public interface TodoListOperations {

    TodoList create(Integer userId, SaveTodoRequest request);

    void update(UUID id, SaveTodoRequest request);

    void updateStatus(UUID id, TodoStatus status);

    TodoList getById(UUID id);

    void deleteById(UUID id);

    List<TodoList> getAllByUserIdAndStatus(Integer userId, TodoStatus status);

}
