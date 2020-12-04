package com.example.projectserver.models;

public class Review {
    private String restaurantId;
    private String userId;

    public Review(String restaurantId,String userId) {
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setRestaurantId( String newResId) {
        this.restaurantId = newResId;
    }

    public void  setUserId (String newUserId) {
        this.userId = newUserId;
    }

}
