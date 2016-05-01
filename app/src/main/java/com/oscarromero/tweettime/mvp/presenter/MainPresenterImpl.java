package com.oscarromero.tweettime.mvp.presenter;

import android.os.CountDownTimer;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.tweettime.mvp.model.TweetPM;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Oscar on 28/4/16.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainPresenterView presenterView;
    private Interactor<List<Tweet>> getTweetsInteractor;
    private Subscription twitterSubscription;

    private List<Tweet> tweets;
    private int tweetCounter = 0;

    public MainPresenterImpl(MainPresenterView presenterView, Interactor<List<Tweet>> getTweetsInteractor) {
        this.presenterView = presenterView;
        this.getTweetsInteractor = getTweetsInteractor;
    }

    @Override
    public void getTweet() {
        presenterView.showLoading();
        twitterSubscription = getTweetsInteractor.run()
                .subscribe(new Action1<List<Tweet>>() {
                    @Override
                    public void call(List<Tweet> tweets) {
                        MainPresenterImpl.this.tweets = tweets;
                        Collections.sort(MainPresenterImpl.this.tweets, new Comparator<Tweet>() {
                            @Override
                            public int compare(Tweet tweet, Tweet t1) {
                                int retweets = tweet.getRetweets();
                                int retweets1 = t1.getRetweets();
                                int sComp = retweets1 - retweets;

                                if (sComp != 0) {
                                    return sComp;
                                } else {
                                    Date date = tweet.getCreateAt();
                                    Date date1 = t1.getCreateAt();
                                    return date1.compareTo(date);
                                }
                            }
                        });
                        int second = Calendar.getInstance().get(Calendar.SECOND);
                        updateTweets(60 - second);
                        presenterView.hideLoading();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        presenterView.hideLoading();
                        presenterView.hideTweet();
                        presenterView.showEmptyView();
                    }
                });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        twitterSubscription.unsubscribe();
    }

    private void updateTweets(int seconds) {

        new CountDownTimer(seconds * 1000, 6000) {
            public void onTick(long millisUntilFinished) {
                showTweet();
            }

            public void onFinish() {
                tweetCounter = 0;
                getTweet();
                cancel();
            }
        }.start();
    }

    private void showTweet() {
        if (!tweets.isEmpty()) {
            presenterView.hideEmptyView();
            presenterView.showTweet(new TweetPM(tweets.get(tweetCounter)));
            tweetCounter++;
            if (tweetCounter >= tweets.size()) {
                tweetCounter = 0;
            }
        } else {
            presenterView.hideTweet();
            presenterView.showEmptyView();
        }
    }
}