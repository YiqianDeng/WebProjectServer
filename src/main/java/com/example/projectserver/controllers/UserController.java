package com.example.projectserver.controllers;

import com.example.projectserver.models.User;
import com.example.projectserver.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController   //add behavior accessible on the web
@CrossOrigin(origins = "*") //no limited to access
public class UserController {

    @Autowired
    userService service;


    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

//    @GetMapping("/api/users/{userId}")
//    public User findUserByID (@PathVariable("userId")Integer userId) {
//        return service.findUserByID(userId);
//    }

    @GetMapping("/api/users/{username}")
    public User findUserByUsername (@PathVariable("username")String username) {
        return service.findUserByUsername(username);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User newUser) {
        return service.updateUser(userId, newUser);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        service.deleteUser(userId);

    }
}
