package com.lman.application.model;

public class UserInfo {
    private String firstName;
    private String secondName;
    private String email;
    private String timestamp;
    private String isLogged;

    public UserInfo(String firstName, String secondName, String email, String timestamp, String isLogged) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.timestamp = timestamp;
        this.isLogged = isLogged;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getIsLogged() {
        return isLogged;
    }

    @Override
    public String toString() {
        return "UserInfo {" + firstName + " " + secondName + " " + email + " " + timestamp + " " + isLogged + "}";
    }
}
