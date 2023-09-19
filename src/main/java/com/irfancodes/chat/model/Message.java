package com.irfancodes.chat.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Chat chat;

    private int senderId;

    private String content;

    private LocalDateTime timestamp;

    // Constructors, getters, setters
    public Message() {
    }
    public Message(Chat chat, int senderId, String content, LocalDateTime timestamp) {
        this.chat = chat;
        this.senderId = senderId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Message(Chat chat, int senderId, String content) {
        this.chat = chat;
        this.senderId = senderId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }



    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
