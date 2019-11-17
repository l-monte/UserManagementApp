package com.lman.application.controllers;

import com.lman.application.helpers.UserInfoBuilder;
import com.lman.application.model.User;
import com.lman.application.model.UserInfo;
import com.lman.application.services.SessionService;
import com.lman.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RESTController {

    @Autowired
    private UserInfoBuilder builder;

    @Autowired
    private SessionService loggedUserRepo;

    @Autowired
    private UserService userRepo;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public List<UserInfo> getUsersPage(@RequestParam(value = "page") String page,
                                       @RequestParam(value = "size") String size) {

        PageRequest pageReq = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));

        return builder.buildUserInfoList(userRepo.findAll(pageReq).getContent());
    }

    @GetMapping("/userss")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/loggedusersnumber")
    public long getLoggedUsers() { return loggedUserRepo.getLoggedUsersNumber(); }

    @GetMapping("/usersnumber")
    public long getUserNumber() { return userRepo.getUsersNumber(); }

    @GetMapping("/validateuser")
    public Boolean validateUser(@RequestParam("email") String email) {

        UUID id = userRepo.findbyEmail(email);
        if (id != null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/userlogged")
    public ResponseEntity setUserLogged(@RequestBody String email) {

        UUID id = userRepo.findbyEmail(email);
        if (id != null) {
            User user = userRepo.findById(id);
            user.setTimestamp(LocalDateTime.now());
            userRepo.delete(id);
            userRepo.save(user);

            loggedUserRepo.saveId(id);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There is no such user");
        }
    }
}
