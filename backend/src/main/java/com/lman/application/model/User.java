package com.lman.application.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private String firstName;
    private String secondName;
    private String email;
    private Long timestamp;

    public User(UUID id, String firstName, String secondName, String email, long timestamp) {
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

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User {" + id.toString() + " " + firstName + " " + secondName + " " + email + " " + timestamp.toString() + "}";
    }
}

