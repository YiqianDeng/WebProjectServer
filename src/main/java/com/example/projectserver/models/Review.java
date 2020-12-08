package com.example.projectserver.models;

public class Review {
    private String restaurantId;
    private String userName;
    private String text;

    public Review(String restaurantId,String userName, String text) {
        this.restaurantId = restaurantId;
        this.userName = userName;
        this.text = text;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }

    public void setRestaurantId( String newResId) {
        this.restaurantId = newResId;
    }

    public void  setUserName (String newUserName) {
        this.userName = newUserName;
    }

    public void setText (String newText) { this.text = newText;}

}
