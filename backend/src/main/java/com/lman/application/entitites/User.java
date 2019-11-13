package com.lman.application.entitites;

import java.sql.Timestamp;

public class User {
    private final UserId id;
    private String firstName;
    private String secondName;
    private String email;
    private Long timestamp;

    public User(UserId id, String firstName, String secondName, String email, long timestamp) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.timestamp = timestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public UserId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User {" + id.getId().toString() + " " + firstName + " " + secondName + " " + email + " " + timestamp.toString() + "}";
    }
}

