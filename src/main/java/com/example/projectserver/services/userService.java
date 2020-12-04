package com.example.projectserver.services;

import com.example.projectserver.models.User;
import com.example.projectserver.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    UsersRepository usersRepository;

    public List<User> findAllUsers() {
        return (List<User>) usersRepository.findAll();
    }

    public User findUserByID (Integer userId) {
        return usersRepository.findById(userId).get();
    }

//    public User findUserByUsername (String username) {
//        return usersRepository.findUserByUsername(username);
//    }

    public Integer createUser(@RequestBody User user) {
        return usersRepository.save(user).getId(); //insert
    }

    public User updateUser(Integer userId, User newUser) {
        Optional userO = usersRepository.findById(userId);
        if(userO.isPresent()){
            User user = (User) userO.get();
            user.setPhone(newUser.getPhone());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setDateofbirth(newUser.getDateofbirth());
            user.setAddress(newUser.getAddress());
            return usersRepository.save(user);
        }else {
            return null;
        }

    }

    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

}
