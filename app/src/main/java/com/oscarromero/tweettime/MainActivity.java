package com.oscarromero.tweettime;

import android.os.Bundle;

import com.oscarromero.tweettime.di.MainModule;
import com.oscarromero.tweettime.mvp.model.TweetPM;
import com.oscarromero.tweettime.mvp.presenter.MainPresenter;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenterView {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getModules() != null) {
            activityGraph = ((TweetTimeApp) getApplication()).createScopedGraph(getModules().toArray());
            activityGraph.inject(this);
        }
        mainPresenter.getTweet();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    @Override
    public void showTweet(TweetPM tweetPM) {

    }

    @Override
    public void showLoading(int messageResource) {

    }

    @Override
    public void hideLoading() {

    }
}