package com.alevel.java.todolist.entity.request;

import java.util.Collections;

public class SaveRegularUserRequest {

    public static final String REGULAR_USER_ROLE_NAME = "USER";

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SaveUserRequest toSaveRequest() {
        var saveRequest = new SaveUserRequest();
        saveRequest.setUsername(username);
        saveRequest.setPassword(password);
        saveRequest.setRoles(Collections.singleton(REGULAR_USER_ROLE_NAME));
        return saveRequest;
    }

}
