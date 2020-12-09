package com.example.projectserver.services;

import com.example.projectserver.models.Review;
import com.example.projectserver.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class reviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> findAllReviews() {

        return (List<Review>) reviewRepository.findAll();
    }

    public List<Review> findReviewsByRestaurantAndUser(String userName, String resId) {

        return reviewRepository.findReviewsByRestaurantAndUser(resId, userName);
    }

    public Review createReview(String userName, String resId, Review newReview) {
        newReview.setRestaurantId(resId);
        newReview.setUserName(userName);
        return reviewRepository.save(newReview);
    }



}
