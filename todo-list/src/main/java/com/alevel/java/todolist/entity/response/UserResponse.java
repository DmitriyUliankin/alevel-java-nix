package com.alevel.java.todolist.entity.response;

import com.alevel.java.todolist.entity.Role;
import com.alevel.java.todolist.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserResponse {

    private Integer id;

    private String username;

    private Set<String> roles;

    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())
        );
    }

    public UserResponse() {
    }

    public UserResponse(Integer id, String username, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
