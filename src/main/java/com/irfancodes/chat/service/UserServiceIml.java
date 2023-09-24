package com.irfancodes.chat.service;

import com.irfancodes.chat.model.Chat;
import com.irfancodes.chat.model.User;
import com.irfancodes.chat.repository.ChatRepository;
import com.irfancodes.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

import static java.util.Collections.sort;


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
    public User getONEUserByName(String firstName) {
        User user = userRepository.findByName(firstName);

        return user;
    }

    @Override
    public User getONEUserByEmail(String Email) {
        User user = userRepository.findByEmail(Email);

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
            User user1 = userRepository.findByEmail(email);
            User user2 = userRepository.findByName(firstName);



            if(user1 != null && user2 != null){

                int user1Id = user1.getId();
                int user2Id = user2.getId();
                Set<String> friends1 = user1.getFriends();
                Set<String> friends2 = user1.getFriends();
//                if(friends1==null){
//                    friends1 = new HashSet<>();
//                }
//                if(friends2==null){
//                    friends2 = new HashSet<>();
//                }

                friends1.add(user2.getName());
                friends2.add(user1.getName());

                user1.setFriends(friends1);
                user2.setFriends(friends2);
                String email1 = user1.getEmail();
                String email2 = user2.getEmail();
                String chatEmail = email1+email2;
                List<String> emailss = new ArrayList<>();
                emailss.add(email1);
                emailss.add(email2);
                sort(emailss);
                Chat chat = new Chat(user1Id,user2Id,chatEmail);
                chatRepository.save(chat);


                Set<Integer> chats1 = user1.getChats();
                Set<Integer> chats2 = user2.getChats();

                if(chats1 == null){
                    chats1 = new HashSet<>();
                }
                if(chats2 == null){
                    chats2 = new HashSet<>();
                }
                chats1.add(chat.getId()); /// will this get chatID??
                chats2.add((chat.getId()));

                user1.setChats(chats1);
                user2.setChats(chats2);
                userRepository.save(user2);
                userRepository.save(user1);
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
            Set<String> empty = new HashSet<String>();
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
