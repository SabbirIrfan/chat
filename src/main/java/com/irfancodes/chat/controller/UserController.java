package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.model.User;
import com.irfancodes.chat.service.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceIml userServiceIml;

    @GetMapping("/getAll")
    public List<User> list(){
        return userServiceIml.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getEntityById(@PathVariable Integer id) {
        return userServiceIml.getONEUser(id);
    }

    // Delete a user by ID
    @DeleteMapping("del/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        return userServiceIml.deleteUser(id);
    }

}
