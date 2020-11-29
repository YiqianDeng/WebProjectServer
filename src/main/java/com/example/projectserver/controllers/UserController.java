package com.example.projectserver.controllers;

import com.example.projectserver.models.User;
import com.example.projectserver.services.userService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController   //add behavior accessible on the web
@CrossOrigin(origins = "*") //no limited to access
public class UserController {
    userService service = new userService();
    List<User> users = new ArrayList<>();
    {
        users.add(new User("123", "sherry1111@gmail.com", "123"));
        users.add(new User("234", "sherry2222@gmail.com", "234"));
        users.add(new User("345", "sherry3333@gmail.com", "345"));
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserByID (
            @PathVariable("userId")String userId) {
        return service.findUserByID(userId);
    }


    @GetMapping("/api/users/{username}")
    public User findUserByUsername (
            @PathVariable("username")String username) {
        return service.findUserByUsername(username);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/api/users/{userId}")
    public Integer updateUser(@PathVariable("userId") String userId, @RequestBody User newUser) {
        return service.updateUser(userId, newUser);
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
