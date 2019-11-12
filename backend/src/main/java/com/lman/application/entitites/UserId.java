package com.lman.application.entitites;

public class UserId {

    private final Integer id;

    public UserId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        UserId other = (UserId)o;

        if (this.id == other.id)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "UserId{#" + id + "}";
    }
}
