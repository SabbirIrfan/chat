package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;
import com.irfancodes.chat.repository.ChatRepository;
import com.irfancodes.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public String addMessage(Message message) {

        messageRepository.save(message);

        return "message has been saved to database successfully";
    }

    @Override
    public List<Message> getAllMessage(Integer chatId) {


        return   messageRepository.findByChatId(chatId);
    }
}