package com.nagarro.nagp.assignment.userservice.controller;


import com.nagarro.nagp.assignment.userservice.model.User;
import com.nagarro.nagp.assignment.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @Autowired
    UserService userService;

    @GetMapping("/user/{user-id}")
    public User getUser(@PathVariable(value = "user-id") int userId) {
        return userService.getUser(userId);
    }
}
