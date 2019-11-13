package com.lman.application.repositories;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import com.lman.application.utils.IdGenerator;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository  {

    private Map<UserId, User> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();

        for (User user: UserRepoMaker.generateUsers()) {
            users.put(user.getId(), user);
        }
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

    public long getUserNumber() {
        return users.size();
    }
}

class UserRepoMaker
{
    private final static int USER_NUMBER = 20;
    private final static String EMAIL_DOMAIN = "@gmail.com";

    private static ArrayList<String> names = new ArrayList<>(Arrays.asList("Oliver", "Jack", "Jacob", "Charlie", "Thomas",
                                                                           "John", "Julie", "Jennifer", "Helen", "Rachel"));

    private static ArrayList<String> secondNames = new ArrayList<>(Arrays.asList("Smith", "Jones", "Williams", "Taylor", "Davies"));

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<User>();
        IdGenerator idGen = new IdGenerator();


        for (int i = 0; i < USER_NUMBER; i++) {

            String fName = getRandomName();
            String sName = getRandomSecondName();
            String email = fName.toLowerCase() + "." + sName.toLowerCase() + EMAIL_DOMAIN;
            users.add(new User(new UserId(idGen.uniqueId()), fName, sName, email, Long.valueOf(System.currentTimeMillis() / 1000)));
        }
        return users;
    }

    private static String getRandomName() {
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }

    private static String getRandomSecondName() {
        Random rand = new Random();
        return secondNames.get(rand.nextInt(secondNames.size()));
    }
}
