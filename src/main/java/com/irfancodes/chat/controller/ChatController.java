package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;
import com.irfancodes.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping("/addChat")
    public String add(@RequestBody Chat chat){
        return chatService.addChat(chat);

    }
    @PostMapping("/addMessage")
    public String add(@RequestBody Message message){
        return chatService.addMessage(message);

    }
    @GetMapping("/getAllMessage/{id}")
    public List<Message> add(@PathVariable Integer id){

        List<Message> messages =  chatService.getAllMessage(id);
        List<Message> sortedList = messages.stream()
                .sorted((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()))
                .toList();

        return sortedList;

    }
}
