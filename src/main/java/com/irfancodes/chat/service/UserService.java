package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public Void register(User user);
    public User login(String email) ;

    public List<User> getAllUsers();

    public ResponseEntity<User> deleteUser(Integer id);

    public ResponseEntity<User> getONEUser(Integer id);

}
