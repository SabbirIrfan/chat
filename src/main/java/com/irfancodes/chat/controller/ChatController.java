package com.irfancodes.chat.controller;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.Message;
import com.irfancodes.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/getAllMessage/:{id}")
    public List<Message> add(@PathVariable Integer id){
        return chatService.getAllMessage(id);

    }
}
