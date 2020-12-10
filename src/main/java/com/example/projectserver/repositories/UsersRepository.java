package com.example.projectserver.repositories;

import com.example.projectserver.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//connect database
public interface UsersRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from users where username=:username", nativeQuery = true)
    public User findUserByUsername(String username);

}
