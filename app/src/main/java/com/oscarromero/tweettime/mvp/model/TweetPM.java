package com.oscarromero.tweettime.mvp.model;

import com.oscarromero.domain.entities.Tweet;

import java.text.SimpleDateFormat;

/**
 * Created by Oscar on 28/4/16.
 */
public class TweetPM {
    private Tweet tweet;

    public TweetPM(Tweet tweet) {
        this.tweet = tweet;
    }

    public String getName() {
        return tweet.getUser().getName();
    }

    public String getUsername() {
        return "(@" + tweet.getUser().getUsername() + ")";
    }

    public String getMessage() {
        return tweet.getMessage();
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm");
        return simpleDateFormat.format(tweet.getCreateAt());
    }

    public String getImage() {
        return tweet.getUser().getProfileImageUrl();
    }
}