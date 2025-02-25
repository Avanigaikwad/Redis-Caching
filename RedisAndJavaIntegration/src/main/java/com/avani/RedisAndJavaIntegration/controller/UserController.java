package com.avani.RedisAndJavaIntegration.controller;

import com.avani.RedisAndJavaIntegration.model.User;
import com.avani.RedisAndJavaIntegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
