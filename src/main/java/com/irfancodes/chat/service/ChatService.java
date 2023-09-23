package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;

import java.util.ArrayList;
import java.util.List;

public interface ChatService {
    public String addChat(Chat chat) ;
    public String addMessage(Message message);

    public List<Message> getAll() ;
    public List<Message> getAllMessage(Integer chatId);
    public Chat getChatIdByEmail(String email1, String email2);


    }
