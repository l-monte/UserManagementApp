package com.lman.application.services;

import com.lman.application.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sun.security.ssl.HandshakeOutStream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserService {

    private Map<UUID, User> userMap;
    private List<User> userList;

    public UserService() {
        userMap = new ConcurrentHashMap<>();
        userList = new ArrayList<>();

        for (User user: UserRepoMaker.generateUsers()) {
            userMap.put(user.getId(), user);
            userList.add(user);
        }
    }

    public Page<User> findAll(Pageable pageReq) {

        int start = (int) pageReq.getOffset();
        int end = (int) ((start + pageReq.getPageSize()) > userList.size() ? userList.size()
                : (start + pageReq.getPageSize()));

        return new PageImpl<User>(userList.subList(start, end), pageReq, userList.size());
    }

    public List<User> findAll() {
        List<User> result = new ArrayList(userMap.values());
        return result;
    }

    public void delete(UUID id) {
        userMap.remove(id);
    }

    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    public boolean existsById(Integer id) {
        return userMap.containsKey(id);
    }

    public User findById(UUID id) {
        return userMap.get(id);
    }

    public UUID findbyEmail(String email) {
        for (User user: userMap.values()) {
            if (user.getEmail().equals(email))
                return user.getId();
        }
        return null;
    }

    public long getUsersNumber() {
        return userMap.size();
    }
}

class UserRepoMaker
{
    private final static int USER_NUMBER = 100;
    private final static String EMAIL_DOMAIN = "@gmail.com";

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < USER_NUMBER; i++) {

            String fName = "user" + String.valueOf(i);
            String sName = "surname";
            String email = fName + "." + sName + EMAIL_DOMAIN;
            users.add(new User(UUID.randomUUID(), fName, sName, email, LocalDateTime.now().minus(1, ChronoUnit.HOURS)));
        }
        return users;
    }
}
