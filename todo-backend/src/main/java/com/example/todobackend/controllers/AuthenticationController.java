package com.example.todobackend.controllers;

import com.example.todobackend.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }
}
