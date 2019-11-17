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
    @Autowired
    private SessionService sessionService;

    public UserInfoBuilder() {
    }

    public List<UserInfo> buildUserInfoList(List<User> userList) {

        List<UserInfo> userInfoList = new ArrayList<>();

         userList.stream().forEach(user -> {

            LocalDateTime timestamp =
                    Instant.ofEpochMilli(user.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = timestamp.format(timestampFormat);

            UserInfo info = new UserInfo(
                    user.getFirstName(),
                    user.getSecondName(),
                    user.getEmail(),
                    formattedDate,
                    sessionService.isLogged(user.getId()) ? "LOGGED" : "not logged"
            );

            userInfoList.add(info);
        });

        return userInfoList;
    }
}
