package com.alevel.java.todolist.repository;

import com.alevel.java.todolist.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
