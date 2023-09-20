package com.irfancodes.chat.repository;

import com.irfancodes.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    ArrayList<Message> findByChatId(Integer chatId);
}
