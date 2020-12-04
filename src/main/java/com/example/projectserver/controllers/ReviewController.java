package com.example.projectserver.controllers;

import com.example.projectserver.models.Review;
import com.example.projectserver.services.reviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController   //add behavior accessible on the web
@CrossOrigin(origins = "*")
public class ReviewController {
    reviewService service = new reviewService();


    @GetMapping("/api/reviews")
    public List<Review> findAllReviews() {
        return service.findAllReviews();
    }

    @GetMapping("/api/{restaurantId}/{userId}/reviews")
    public List<Review> findReviewsByRestaurantAndUser(@PathVariable("userId")String userId,
                                                       @PathVariable("restaurantId") String restaurantId) {
        return service.findReviewsByRestaurantAndUser(userId,restaurantId);
    }

    @PostMapping("/api/{restaurantId}/{userId}/reviews")
    public Review createReview(@PathVariable("userId")String userId,
                               @PathVariable("restaurantId") String restaurantId,
                               @RequestBody Review newReview) {
        return service.createReview(userId, restaurantId, newReview);
    }


}
