package com.irfancodes.chat.repository;

import com.irfancodes.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
    Chat findByEmails(String email);
}
