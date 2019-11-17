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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RESTController {

    @Autowired
    private UserInfoBuilder builder;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public List<UserInfo> getUsersPage(@RequestParam(value = "page") String page,
                                       @RequestParam(value = "size") String size) {

        PageRequest pageReq = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));

        return builder.buildUserInfoList(userService.findAll(pageReq).getContent());
    }

    @GetMapping("/userss")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/activesessnumber")
    public long getLoggedUsers() { return sessionService.getLoggedUsersNumber(); }

    @GetMapping("/usersnumber")
    public long getUserNumber() { return userService.getUsersNumber(); }

    @GetMapping("/validateuser")
    public Boolean validateUser(@RequestParam("email") String email) {

        UUID id = userService.findbyEmail(email);
        if (id != null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/activesession")
    public ResponseEntity setUserLogged(@RequestBody String email) {

        UUID id = userService.findbyEmail(email);
        if (id != null) {
            User user = userService.findById(id);
            user.setTimestamp(LocalDateTime.now());
            userService.delete(id);
            userService.save(user);

            sessionService.saveId(id);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There is no such user");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity logoutUser(@RequestBody String email) {

        UUID id = userService.findbyEmail(email);
        if (id != null) {
            User user = userService.findById(id);
            sessionService.deleteId(id);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User " + email + " is already logged off");
        }
    }
}
