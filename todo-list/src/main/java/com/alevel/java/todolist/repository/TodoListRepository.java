package com.alevel.java.todolist.repository;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {

    List<TodoList> findAllByUser_IdAndStatus(Integer userId, TodoStatus status);

}
