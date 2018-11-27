package com.example.lebed.zenvo.Class;

import android.media.Image;

public class Contractor {

    private String firstName;
    private String lastName;
    private Double rating;
    private Integer numberOfReviews;
    private String city;
    private boolean inFavorites;

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

    public Image getAvatar() {
        return avatar;
    }

    public Contractor(String firstName, String lastName, Double rating, Integer numberOfReviews, String city, boolean inFavorites, Image avatar) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.city = city;
        this.inFavorites = inFavorites;
        this.avatar = avatar;
    }

    private Image avatar;


}
