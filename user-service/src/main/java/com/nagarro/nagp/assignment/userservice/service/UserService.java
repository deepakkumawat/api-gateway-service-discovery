package com.nagarro.nagp.assignment.userservice.service;

import com.nagarro.nagp.assignment.userservice.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<Integer, User> USER_DB = new HashMap<>();

    @PostConstruct
    public void initUserDB(){
        USER_DB.put(1, new User(1, "Ram"));
        USER_DB.put(2, new User(2, "Sita"));
    }

    public User getUser(int userId){
        return USER_DB.get(userId);
    }
}
