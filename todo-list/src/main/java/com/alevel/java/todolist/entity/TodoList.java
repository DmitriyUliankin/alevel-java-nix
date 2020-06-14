package com.alevel.java.todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo_list")
public class TodoList {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "text", nullable = false)
    String text;

    @Column(name = "is_done", nullable = false)
    Boolean status;

    public TodoList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
