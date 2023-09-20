package com.irfancodes.chat.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int user1Id;

    private int user2Id;

    private String emails;

    public String getEmails() {
        return emails;
    }

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)


    public void setEmails(String emails) {
        this.emails = emails;
    }


    // Constructors, getters, setters

//    public Chat(int user1Id, int user2Id) {
//        this.user1Id = user1Id;
//        this.user2Id = user2Id;
//    }
//
//    public Chat(int user1Id, int user2Id, ArrayList<Message> messages) {
//        this.user1Id = user1Id;
//        this.user2Id = user2Id;
//        this.messages = messages;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }

}
