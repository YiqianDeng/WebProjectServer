package com.example.projectserver.repositories;

import com.example.projectserver.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//connect database
public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query(value = "select * from reviews where restaurant_id =:restaurantId and user_name =:userName", nativeQuery = true)
    public List<Review> findReviewsByRestaurantAndUser( String restaurantId, String userName);




}
