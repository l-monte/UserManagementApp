package com.lman.application.controllers;

import com.lman.application.entitites.User;
import com.lman.application.repositories.LoggedUserRepository;
import com.lman.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RESTController {

    @Autowired
    private LoggedUserRepository loggedUserRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/loggedusersnumber")
    public long getLoggedUsers() { return loggedUserRepo.getLoggedUsersNumber(); }

    @GetMapping("/usersnumber")
    public long getUserNumber() { return userRepo.getUserNumber(); }
}
