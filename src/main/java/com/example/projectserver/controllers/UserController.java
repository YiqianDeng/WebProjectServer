package com.example.projectserver.controllers;

import com.example.projectserver.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController   //add behavior accessible on the web
public class UserController {
    List<User> users = new ArrayList<>();
    {
        users.add(new User("123", "sherry1111@gmail.com", "123"));
        users.add(new User("234", "sherry2222@gmail.com", "234"));
        users.add(new User("345", "sherry3333@gmail.com", "345"));
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return users;
    }

    @GetMapping("/api/users/{userId}")
    public User findUserByID (
            @PathVariable("userId")String userId) {
        for(User user: users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        user.setId((new Date()).toString());
        users.add(user);
        return user;
    }

    @PutMapping("/api/users/{userId}")
    public Integer updateUser(@PathVariable("userId") String userId, @RequestBody User newUser) {
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
