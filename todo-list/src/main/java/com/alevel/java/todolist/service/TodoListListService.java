package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.changereq.ChangeRequest;
import com.alevel.java.todolist.exception.TodoNotFoundException;
import com.alevel.java.todolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TodoListListService implements TodoListOperations {

    private final TodoListRepository repository;

    public TodoListListService(TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodoList create(ChangeRequest request) {
        var todo = new TodoList();
        todo.setText(request.getText());
        todo.setStatus(request.getStatus());
        return repository.save(todo);
    }

    @Override
    public void changeStatus(Long id) {
        var todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todo.setStatus(true);
    }

    @Override
    public List<TodoList> getAllNotDone() {
        return repository.findAll()
                .stream()
                .filter((task) -> task.getStatus().equals(false))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoList> getAllTodo() {
        return repository.findAll();
    }

    @Override
    public Optional<TodoList> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Long id, ChangeRequest request) {
        var todo = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todo.setText(request.getText());
        todo.setStatus(request.getStatus());
        repository.save(todo);
    }

    @Override
    public Optional<TodoList> deleteById(Long id) {
        var todo = repository.findById(id);
        todo.ifPresent(repository::delete);
        return todo;
    }

}
