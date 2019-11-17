package com.lman.application.helpers;

import com.lman.application.model.User;
import com.lman.application.model.UserInfo;
import com.lman.application.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoBuilder
{
    private final String LOGGED = "LOGGED";
    private final String NOT_LOGGED = "not logged";

    @Autowired
    private SessionService sessionService;

    public UserInfoBuilder() {
    }

    public List<UserInfo> buildUserInfoList(List<User> userList) {

        List<UserInfo> userInfoList = new ArrayList<>();

         userList.stream().forEach(user -> {

            DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = user.getTimestamp().format(timestampFormat);

            UserInfo info = new UserInfo(
                    user.getFirstName(),
                    user.getSecondName(),
                    user.getEmail(),
                    formattedDate,
                    sessionService.isLogged(user.getId()) ? LOGGED : NOT_LOGGED
            );

            userInfoList.add(info);
        });

        return userInfoList;
    }
}
