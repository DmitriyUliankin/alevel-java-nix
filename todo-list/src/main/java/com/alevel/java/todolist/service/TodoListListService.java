package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.TodoList;
import com.alevel.java.todolist.entity.TodoStatus;
import com.alevel.java.todolist.entity.request.SaveTodoRequest;
import com.alevel.java.todolist.exception.TodoNotFoundException;
import com.alevel.java.todolist.exception.UserNotFoundException;
import com.alevel.java.todolist.repository.TodoListRepository;
import com.alevel.java.todolist.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TodoListListService implements TodoListOperations {

    private final TodoListRepository todoListRepository;

    private final UserRepository userRepository;

    public TodoListListService(TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TodoList create(Integer userId, SaveTodoRequest request) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        var todo = new TodoList();
        todo.setUser(user);
        todo.setText(request.getText());
        todo.setStatus(request.getStatus());

        user.getTodos().add(todo);

        return todoListRepository.save(todo);
    }

    @Override
    public void update(UUID id, SaveTodoRequest request) {
        var existingTodo = getById(id);
        existingTodo.setStatus(request.getStatus());
        existingTodo.setText(request.getText());
        todoListRepository.save(existingTodo);
    }

    @Override
    public void updateStatus(UUID id, TodoStatus status) {
        var existingTodo = getById(id);
        existingTodo.setStatus(status);
        todoListRepository.save(existingTodo);
    }

    @Override
    public TodoList getById(UUID id) {
        return todoListRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public void deleteById(UUID id) {
        todoListRepository.findById(id);
    }

    @Override
    public List<TodoList> getAllByUserIdAndStatus(Integer userId, TodoStatus status) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        return todoListRepository.findAllByUser_IdAndStatus(userId, status);
    }

}
