package com.oscarromero.tweettime.mvp.presenter;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.List;

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
        getTweetsInteractor.run();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}