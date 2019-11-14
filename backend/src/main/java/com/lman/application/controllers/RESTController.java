package com.lman.application.controllers;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import com.lman.application.repositories.LoggedUserRepository;
import com.lman.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public long getUserNumber() { return userRepo.getUsersNumber(); }

    @PostMapping("/userlogged")
    public ResponseEntity setUserLogged(@RequestBody String email) {

        System.out.println("DEBUG: POST method of setUserLogged(): received logged email: " + email);

        UserId id = userRepo.findbyEmail(email);
        if (id != null) {
            User user = userRepo.findById(id);  
            user.setTimestamp(Long.valueOf(System.currentTimeMillis() / 1000));

            loggedUserRepo.saveId(id);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There is no such user");
        }
    }
}
