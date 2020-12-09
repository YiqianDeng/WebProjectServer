package com.example.projectserver.controllers;

import com.example.projectserver.models.Review;
import com.example.projectserver.services.reviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController   //add behavior accessible on the web
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    reviewService service;


    @GetMapping("/api/reviews")
    public List<Review> findAllReviews() {
        return service.findAllReviews();
    }

    @GetMapping("/api/reviews/{restaurantId}/{userName}")
    public List<Review> findReviewsByRestaurantAndUser(@PathVariable("userName")String userName,
                                                       @PathVariable("restaurantId") String restaurantId) {
        return service.findReviewsByRestaurantAndUser(userName,restaurantId);
    }

    @PostMapping("/api/reviews/{restaurantId}/{userName}")
    public Review createReview(@PathVariable("userName")String userName,
                               @PathVariable("restaurantId") String restaurantId,
                               @RequestBody Review newReview) {
        return service.createReview(userName, restaurantId, newReview);
    }




}
