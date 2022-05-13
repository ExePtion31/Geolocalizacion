package com.uninpahu.database.database.request;

public class LoginResponse {
    private int id;
    private int role;
    private String message;

    public LoginResponse(int id, int role, String message) {
        this.id = id;
        this.role = role;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
