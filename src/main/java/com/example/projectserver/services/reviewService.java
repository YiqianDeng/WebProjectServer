package com.example.projectserver.services;

import com.example.projectserver.models.Review;

import java.util.ArrayList;
import java.util.List;

public class reviewService {
    List<Review> reviews = new ArrayList<>();


    public List<Review> findAllReviews() {
        return reviews;
    }

    public List<Review> findReviewsByRestaurantAndUser(String userName, String resId) {
        List<Review> newReviews = new ArrayList<>();
        for(Review review: reviews) {
            if(review.getUserName().equals(userName) && review.getRestaurantId().equals(resId)) {
                newReviews.add(review);
            }
        }
        return newReviews;
    }

    public Review createReview(String userName, String resId, Review newReview) {
        newReview.setRestaurantId(resId);
        newReview.setUserName(userName);
        reviews.add(newReview);
        return newReview;
    }



}
