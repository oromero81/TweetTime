package com.oscarromero.tweettime.mvp.presenter;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.tweettime.mvp.model.TweetPM;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

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

    public MainPresenterImpl(MainPresenterView presenterView, Interactor<List<Tweet>> getTweetsInteractor) {
        this.presenterView = presenterView;
        this.getTweetsInteractor = getTweetsInteractor;
    }

    @Override
    public void getTweet() {
        twitterSubscription = getTweetsInteractor.run().subscribe(new Action1<List<Tweet>>() {
            @Override
            public void call(List<Tweet> tweets) {
                presenterView.showTweet(new TweetPM(tweets.get(0)));
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
}