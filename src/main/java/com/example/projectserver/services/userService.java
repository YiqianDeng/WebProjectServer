package com.example.projectserver.services;

import com.example.projectserver.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userService {
    List<User> users = new ArrayList<>();
    {
        users.add(new User("123", "sherry1111@gmail.com", "123"));
        users.add(new User("234", "sherry2222@gmail.com", "234"));
        users.add(new User("345", "sherry3333@gmail.com", "345"));
    }

    public List<User> findAllUsers() {
        return users;
    }


    public User findUserByID (String userId) {
        for(User user: users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public User findUserByUsername (String username) {
        for(User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(@RequestBody User user) {
        user.setId((new Date()).toString());
        users.add(user);
        return user;
    }


    public Integer updateUser(String userId, User newUser) {
        for(User user: users) {
            if(user.getId().equals(userId)){
                user.setPassword(newUser.getPassword());
                user.setUsername(newUser.getUsername());
                return 1;
            }
        }
        return 0;
    }

//    @DeleteMapping("/api/users")
//    public Integer deleteUser(String userId) {
//        for(User user: users) {
//            if(user.getId().equals(userId)){
//                users.remove(user);
//                return 1;
//            }
//        }
//        return 0;
//    }


}
