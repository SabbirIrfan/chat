package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Student;
import com.irfancodes.chat.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;


public interface UserService {

    public Void register(User user);
    public User login(String email) ;

    public List<User> getAllUsers();

    public String deleteUser(String firstName);

    public User getONEUserByName(String firstName);
    public User getONEUserByEmail(String Email);
    public void addChat(String email, Integer id);
    public void addFriend(String email,String firstName);
    public Set<String> getFriends(String email);

    public Set<Integer> getChatsByEmail(String email);
    public Set<Integer> getChatsByName(String firstName);



}
