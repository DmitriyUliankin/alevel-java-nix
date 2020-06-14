package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.changereq.ChangeRequest;

import java.util.List;
import java.util.Optional;

public interface TodoListOperations {

    TodoList create(ChangeRequest request);

    void changeStatus(Long id);

    List<TodoList> getAllNotDone();

    List<TodoList> getAllTodo();

    Optional<TodoList> getById(Long id);

    void update(Long id, ChangeRequest request);

    Optional<TodoList> deleteById(Long id);

}
