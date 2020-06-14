package com.alevel.java.todolist.entity.changereq;

public class ChangeRequest {

    private String text;

    private Boolean status;

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
