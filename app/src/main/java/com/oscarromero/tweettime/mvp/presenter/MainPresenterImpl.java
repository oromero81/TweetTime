package com.oscarromero.tweettime.mvp.presenter;

import android.util.Log;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Oscar on 28/4/16.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainPresenterView presenterView;
    private Interactor<List<Tweet>> getTweetsInteractor;

    public MainPresenterImpl(MainPresenterView presenterView, Interactor<List<Tweet>> getTweetsInteractor) {
        this.presenterView = presenterView;
        this.getTweetsInteractor = getTweetsInteractor;
    }

    @Override
    public void getTweet() {
        getTweetsInteractor.run().subscribe(new Action1<List<Tweet>>() {
            @Override
            public void call(List<Tweet> tweets) {
                for (Tweet tweet : tweets) {
                    Log.i("TW", tweet.getMessage());
                }
            }
        });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}