package com.lman.application.repositories;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import com.lman.application.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserRepository  {

    private HashMap<UserId, User> users;

    public UserRepository() {
        System.out.println("MONTE: c-tor of UserRepository");
        this.users = new HashMap<>();
    }

    public List<User> findAll() {
        List<User> result = new ArrayList(users.values());
        return result;
    }

    public void delete(UserId id) {
        users.remove(id);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public boolean existsById(Integer id) {
        return users.containsKey(id);
    }

    public User findById(Integer id) {
        return users.get(id);
    }
}
