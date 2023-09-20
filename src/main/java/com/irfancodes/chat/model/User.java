package com.irfancodes.chat.model;

import jakarta.persistence.*;
import com.irfancodes.chat.model.Chat;

import java.util.ArrayList;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String email;

    private String firstName;
    private String lastName;

    private ArrayList<Integer> chats;




    public void setChats(ArrayList<Integer> chats) {
        this.chats = chats;
    }
    public ArrayList<Integer> getChats() {
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
