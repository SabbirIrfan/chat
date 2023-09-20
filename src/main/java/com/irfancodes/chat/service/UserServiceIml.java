package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.User;
import com.irfancodes.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceIml implements  UserService{
    @Autowired
    private UserRepository userRepository;



    @Override
    public Void register(User user) {
        // Perform password hashing here before saving to the database
        userRepository.save(user);
        return null;
    }
    @Override
    public User login(String email) {
        // Implement login logic here, including password validation
        // Return the authenticated user or null if authentication fails
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> deleteUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            userRepository.delete(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }



    @Override
    public ResponseEntity<User> getONEUser(Integer id) {
        Optional<User> entity = userRepository.findById(id);

        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
