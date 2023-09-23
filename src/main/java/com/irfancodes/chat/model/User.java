package com.irfancodes.chat.model;

import jakarta.persistence.*;
import com.irfancodes.chat.model.Chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String email;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Set<Integer> chats = new HashSet<>();

    private Set<String> friends = new HashSet<>();


    private String lastName;



    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public void setChats(Set<Integer> chats) {
        this.chats = chats;
    }
    public Set<Integer> getChats() {
        return chats;
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


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
