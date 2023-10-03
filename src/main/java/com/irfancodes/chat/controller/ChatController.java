package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;
import com.irfancodes.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping("/addChat")
    public String addChat(@RequestBody Chat chat){
        return chatService.addChat(chat);

    }
    @PostMapping("/addMessage")
//    @SendTo("topic/messages")
    public Message addMessage(@RequestBody Message message){
        String success =  chatService.addMessage(message);
        System.out.println("was hit here" + message);
        return message;

    }
    @GetMapping("/getAllMessage/{id}")
    public List<Message> getAllMessage(@PathVariable Integer id){

        List<Message> messages =  chatService.getAllMessage(id);
        if(messages.isEmpty()) messages = new ArrayList<>();


        return messages;

    }
    @GetMapping("/getAll")
    public List<Message> add(){

        List<Message> messages =  chatService.getAll();

        return messages;

    }

    @GetMapping("/getChatId/{email1}/{email2}")
    public Chat getChatEmails(@PathVariable String email1,@PathVariable String email2){

        return chatService.getChatIdByEmail(email1,email2);


    }
}
