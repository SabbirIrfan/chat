package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.User;
import com.irfancodes.chat.repository.ChatRepository;
import com.irfancodes.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;


@Service
@CrossOrigin
public class UserServiceIml implements  UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;



    @Override
    public Void register(User user) {
        // Perform password hashing here before saving to the database
        userRepository.save(user);
        return null;
    }
    @Override
    public User login(String email) {
        // Implement login logic here, including password validation
        // Return the authenticated user or null if authentication fails
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String firstName) {
        User user = userRepository.findByName(firstName);

        if (user != null) {
            userRepository.delete(user);
            return "deleted";

        } else {
            return "could not delete";
        }


    }



    @Override
    public User getONEUser(String firstName) {
        User user = userRepository.findByName(firstName);

        return user;
    }

    @Override
    public void addChat(String email,Integer id) {
        User user = userRepository.findByEmail(email);


       if(user != null){

           Set<Integer> chat = user.getChats();
           if(chat == null || chat.isEmpty()){
               chat = new HashSet<>();
           }
           chat.add(id);
           user.setChats(chat);
           userRepository.save(user);
           System.out.println(chat);

       }



    }

    @Override
    public void addFriend(String email,String firstName) {
            User user = userRepository.findByEmail(email);
            Set<String> friends = user.getFriends();
            User user1 = userRepository.findByName(firstName);


            if(user != null && user1 != null){

                int user1Id = user.getId();
                int user2Id = user1.getId();
                Set<String> friends1 = user.getFriends();
                Set<String> friends2 = user.getFriends();
                friends1.add(user1.getName());
                friends2.add(user.getName());
                user.setFriends(friends1);
                user1.setFriends(friends2);
                String email1 = user.getEmail();
                String email2 = user1.getEmail();
                String chatEmail = email1+email2;
                Chat chat = new Chat(user1Id,user2Id,chatEmail);
                chatRepository.save(chat);


                Set<Integer> chats1 = user.getChats();
                Set<Integer> chats2 = user1.getChats();

                if(chats1 == null){
                    chats1 = new HashSet<>();
                }
                if(chats2 == null){
                    chats2 = new HashSet<>();
                }
                chats1.add(chat.getId()); /// will this get chatID??
                chats2.add((chat.getId()));

                user.setChats(chats1);
                user1.setChats(chats2);
                userRepository.save(user1);
                userRepository.save(user);
            }
            if(friends==null){
                friends = new HashSet<>();
            }


    }

    @Override
    public Set<String> getFriends(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println(email);
        if (user != null) {
            if(user.getFriends()==null){
                return new HashSet<>();

            }
            return user.getFriends();
        } else {
            Set<String> empty = new HashSet<>();
            return empty;
        }
    }

    @Override
    public Set<Integer> getChatsByEmail(String email) {

        User user = userRepository.findByEmail(email);

        if(user!=null){
            return user.getChats();
        }
        return new HashSet<>();
    }

    @Override
    public Set<Integer> getChatsByName(String firstName) {
        User user = userRepository.findByName(firstName);
        if(user!=null){
            return user.getChats();
        }
        return new HashSet<>();
    }

}
