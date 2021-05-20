package com.example.entities;

public class Greetings {
    private String message;

    public Greetings() {} // important to have empty constructor!!

    public Greetings(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
