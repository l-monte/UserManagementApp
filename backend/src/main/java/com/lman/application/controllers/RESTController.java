package com.lman.application.controllers;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import com.lman.application.repositories.LoggedUserRepository;
import com.lman.application.repositories.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RESTController {

    @Autowired
    private LoggedUserRepository loggedUserRepo;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public List<User> getUsersPage(@RequestParam(value = "page") String page,
                                   @RequestParam(value = "size") String size) {

        System.out.println("DEBUG: getUsersPage() received page: " + page + ", size: " + size);

        PageRequest pageReq = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));

        return userRepo.findAll(pageReq).getContent();
    }

    @GetMapping("/userss")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/loggedusersnumber")
    public long getLoggedUsers() { return loggedUserRepo.getLoggedUsersNumber(); }

    @GetMapping("/usersnumber")
    public long getUserNumber() { return userRepo.getUsersNumber(); }

    @PostMapping("/validateuser")
    public ResponseEntity<Boolean> validateUser(@RequestBody String email) {

        UserId id = userRepo.findbyEmail(email);
        if (id != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/userlogged")
    public ResponseEntity setUserLogged(@RequestBody String email) {

        System.out.println("DEBUG: POST method of setUserLogged(): received logged email: " + email);

        UserId id = userRepo.findbyEmail(email);
        if (id != null) {
            User user = userRepo.findById(id);
            user.setTimestamp(Long.valueOf(Instant.now().toEpochMilli()));
//            userRepo.delete(id);
//            System.out.println("Czy user jest dalej wazny? email: " + user.getEmail() + ", timestamp: " + new Date(user.getTimestamp()).toString());
//            userRepo.save(user);

            loggedUserRepo.saveId(id);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There is no such user");
        }
    }
}
