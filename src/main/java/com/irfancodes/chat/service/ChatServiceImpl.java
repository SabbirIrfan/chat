package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;
import com.irfancodes.chat.repository.ChatRepository;
import com.irfancodes.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public String addChat(Chat chat) {
        if(chatRepository.findByEmails(chat.getEmails())!= null){
            return "chat between these users already exist";
        }
        chatRepository.save(chat);

        return "adding chat successfully";
    }
    public LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
    @Override
    public String addMessage(Message message) {

        messageRepository.save(message);

        return "message has been saved to database successfully";
    }

    @Override
    public List<Message> getAll() {

        List<Message> m =  messageRepository.findAll();
        System.out.println(m+"message");
        return  m;
    }
    @Override
    public List<Message> getAllMessage(Integer chatId) {

        List<Message> m =  messageRepository.findByChatId(chatId);
        System.out.println(m +"message");
        return  m;
    }
}