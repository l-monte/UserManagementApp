package com.lman.application.repositories;

import com.lman.application.entitites.UserId;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoggedUserRepository {

    private Set<UserId> loggedUsers = new HashSet<>();

    public boolean saveId(UserId id) {
        return loggedUsers.add(id);
    }

    public boolean deleteId(UserId id) {
        return loggedUsers.remove(id);
    }

    public boolean isLogged(UserId id) {
        return loggedUsers.contains(id);
    }

    public long getLoggedUsersNumber() { return loggedUsers.size(); }
}
