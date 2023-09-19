package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.User;
import com.irfancodes.chat.service.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserServiceIml userServiceIml;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userServiceIml.register(user);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User authenticatedUser = userServiceIml.login(user.getEmail());
        if (authenticatedUser != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}
