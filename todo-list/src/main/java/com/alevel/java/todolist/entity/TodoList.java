package com.alevel.java.todolist.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "todos")
public class TodoList {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

}
