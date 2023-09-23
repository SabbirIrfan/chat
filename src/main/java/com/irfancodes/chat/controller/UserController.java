package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.model.User;
import com.irfancodes.chat.service.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServiceIml userServiceIml;

    @GetMapping("/getAll")
    public List<User> list(){
        return userServiceIml.getAllUsers();
    }
    @GetMapping("/{firstName}")
    public User getEntityById(@PathVariable String firstName) {
        return userServiceIml.getONEUser(firstName);
    }

    // Delete a user by ID
    @DeleteMapping("delete/{firstName}")
    public String deleteUser(@PathVariable String firstName) {
        return userServiceIml.deleteUser(firstName);
    }

    @PutMapping("addChat/{email}/{chatId}")
    public void addChat(@PathVariable String email,@PathVariable Integer chatId) {
        userServiceIml.addChat(email,chatId);
    }
    @PutMapping("addFriend/{userEmail}/{friendName}")
    public void addFriend(@PathVariable String userEmail,@PathVariable String friendName) {
        userServiceIml.addFriend(userEmail,friendName);
    }
    @GetMapping("getAllFriend/{email}")
    public Set<String> friendList(@PathVariable String email){
        return userServiceIml.getFriends(email);
    }
    @GetMapping("getChatsByName/{fname}")
    public Set<Integer> getChatsByName(@PathVariable String fname){
        return userServiceIml.getChatsByEmail(fname);
    }
    @GetMapping("getChatsByEmail/{email}")
    public Set<Integer> getChatsByEmail(@PathVariable String email){
        return userServiceIml.getChatsByEmail(email);
    }




}
