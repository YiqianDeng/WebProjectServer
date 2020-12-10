package com.example.projectserver.repositories;

import com.example.projectserver.models.User;
import org.springframework.data.repository.CrudRepository;

//connect database
public interface UsersRepository extends CrudRepository<User, Integer> {



}
