package com.oscarromero.tweettime;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.oscarromero.tweettime.customview.TweetView;
import com.oscarromero.tweettime.di.MainModule;
import com.oscarromero.tweettime.mvp.model.TweetPM;
import com.oscarromero.tweettime.mvp.presenter.MainPresenter;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainPresenterView {
    @BindView(R.id.tweet_card)
    CardView tweet_card;
    @BindView(R.id.tweet_view)
    TweetView tweetView;
    @BindView(R.id.loading_view)
    View loading_view;
    @BindView(R.id.empty_view)
    View empty_view;

    @Inject
    MainPresenter mainPresenter;
    @Inject
    ImageNetworkLoader imageNetworkLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.getTweet();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    @Override
    public void showTweet(TweetPM tweetPM) {
        tweet_card.setVisibility(View.VISIBLE);
        tweetView.render(tweetPM, imageNetworkLoader);
    }

    @Override
    public void hideTweet() {
        tweet_card.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loading_view.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading_view.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyView() {
        empty_view.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        empty_view.setVisibility(View.GONE);
    }
}