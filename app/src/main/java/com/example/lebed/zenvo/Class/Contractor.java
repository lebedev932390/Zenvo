package com.example.lebed.zenvo.Class;

import android.media.Image;

public class Contractor {

    private int avatar;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer numberOfReviews;
    private String city;
    private boolean inFavorites;

    public int getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public String getCity() {
        return city;
    }

    public boolean isInFavorites() {
        return inFavorites;
    }

    public Contractor(int avatar, String firstName, String lastName, Double rating, Integer numberOfReviews, String city, boolean inFavorites) {

        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.city = city;
        this.inFavorites = inFavorites;
    }




}
