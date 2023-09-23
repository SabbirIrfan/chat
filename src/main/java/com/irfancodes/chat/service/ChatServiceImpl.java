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

import static java.util.Collections.sort;

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
        System.out.println("i am here in add message");
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
        System.out.println(m +"message is added");
        return  m;
    }

    @Override
    public Chat getChatIdByEmail(String email1, String email2) {
        List<String> emailss = new ArrayList<>();
        emailss.add(email1);
        emailss.add(email2);
        sort(emailss);
        String addedEmail = emailss.get(0)+emailss.get(1);

        Chat ans = chatRepository.findByEmails(addedEmail);
        if(ans!=null){

            return ans;
        }

        return null;
    }
}