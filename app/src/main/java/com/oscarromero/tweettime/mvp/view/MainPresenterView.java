package com.oscarromero.tweettime.mvp.view;

import com.oscarromero.tweettime.mvp.model.TweetPM;

/**
 * Created by Oscar on 28/4/16.
 */
public interface MainPresenterView extends BasePresenterView {
    void showTweet(TweetPM tweetPM);
}