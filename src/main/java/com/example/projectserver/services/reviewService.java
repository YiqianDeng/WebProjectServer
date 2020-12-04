package com.example.projectserver.services;

import com.example.projectserver.models.Review;

import java.util.ArrayList;
import java.util.List;

public class reviewService {
    List<Review> reviews = new ArrayList<>();
    {
        reviews.add(new Review("123", "456"));
        reviews.add(new Review("123", "123"));
        reviews.add(new Review("345", "123"));
    }


    public List<Review> findAllReviews() {
        return reviews;
    }

    public List<Review> findReviewsByRestaurantAndUser(String userId, String resId) {
        List<Review> newReviews = new ArrayList<>();
        for(Review review: reviews) {
            if(review.getUserId().equals(userId) && review.getRestaurantId().equals(resId)) {
                newReviews.add(review);
            }
        }
        return newReviews;
    }

    public Review createReview(String userId, String resId, Review newReview) {
        newReview.setRestaurantId(resId);
        newReview.setUserId(userId);
        reviews.add(newReview);
        return newReview;
    }



}
