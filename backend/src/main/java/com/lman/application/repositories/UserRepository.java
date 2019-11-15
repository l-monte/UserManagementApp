package com.lman.application.repositories;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository  {

    private Map<UserId, User> userMap;
    private List<User> userList;

    public UserRepository() {
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

        Page<User> page = new PageImpl<User>(userList.subList(start, end), pageReq, userList.size());
        return page;
    }

    public List<User> findAll() {
        List<User> result = new ArrayList(userMap.values());
        return result;
    }

    public void delete(UserId id) {
        userMap.remove(id);
    }

    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    public boolean existsById(Integer id) {
        return userMap.containsKey(id);
    }

    public User findById(UserId id) {
        return userMap.get(id);
    }

    public UserId findbyEmail(String email) {
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
            users.add(new User(new UserId(i), fName, sName, email, Long.valueOf(Instant.now().toEpochMilli())));
        }
        return users;
    }
}
