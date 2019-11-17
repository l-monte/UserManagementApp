package com.lman.application.repositories;

import com.lman.application.entitites.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionService {

    private Map<UUID, UUID> activeSessions = new ConcurrentHashMap<>();

    public void saveId(UUID id) {
        activeSessions.put(id, id);
    }

    public void deleteId(UUID id) {
        activeSessions.remove(id);
    }

    public boolean isLogged(UUID id) {
        return activeSessions.containsKey(id);
    }

    public long getLoggedUsersNumber() { return activeSessions.size(); }
}
