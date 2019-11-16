package com.lman.application.repositories;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class SessionService {

    private Set<UUID> activeSessions = new HashSet<>();

    public boolean saveId(UUID id) {
        return activeSessions.add(id);
    }

    public boolean deleteId(UUID id) {
        return activeSessions.remove(id);
    }

    public boolean isLogged(UUID id) {
        return activeSessions.contains(id);
    }

    public long getLoggedUsersNumber() { return activeSessions.size(); }
}
