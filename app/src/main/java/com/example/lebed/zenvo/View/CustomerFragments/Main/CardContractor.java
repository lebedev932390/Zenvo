package com.example.lebed.zenvo.View.CustomerFragments.Main;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;

public class CardContractor {

    private RoundedBitmapDrawable avatar;
    private String name;
    private String rating;
    private String location;
    private String reviewsNumber;

    public Drawable getAvatar() {
        return avatar;
    }

    public CardContractor(RoundedBitmapDrawable avatar, String name, String rating, String location, String reviewsNumber) {
        this.avatar = avatar;
        this.name = name;
        this.rating = rating;
        this.location = location;
        this.reviewsNumber = reviewsNumber;
    }



    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getLocation() {
        return location;
    }

    public String getReviewsNumber() {
        return reviewsNumber;
    }
}
