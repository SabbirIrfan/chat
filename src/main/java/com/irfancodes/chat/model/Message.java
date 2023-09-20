package com.irfancodes.chat.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     ////what does this needed for
    private Integer chatId;

    private Integer senderId;

    private String content;

    private LocalDateTime timestamp;

//    public Message() {
//    }
//    public Message(Integer chatId, Integer senderId, String content, LocalDateTime timestamp) {
//        this.chatId = chatId;
//        this.senderId = senderId;
//        this.content = content;
//        this.timestamp = timestamp;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
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
