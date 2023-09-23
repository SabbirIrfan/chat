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

    private String senderName;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    private String content;


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



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
