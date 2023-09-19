package com.irfancodes.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String email;

    private ArrayList<Integer> chats;
    private ArrayList<User> friends ;

    public ArrayList<Integer> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Integer> chats) {
        this.chats = chats;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    private String firstName;
    private String lastName;

    public User( ArrayList<User> friends) {
        this.friends = friends;
    }


    public Void AddUser(User user){
        this.friends.add(user);
        this.chats.add(user.id);

        return null;
    }
    public Void DeleteUser(User user){
        this.chats.remove(user.id);
        this.friends.remove(user);
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
