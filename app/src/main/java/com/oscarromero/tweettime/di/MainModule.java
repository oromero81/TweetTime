package com.oscarromero.tweettime.di;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.tweettime.MainActivity;
import com.oscarromero.tweettime.mvp.presenter.MainPresenter;
import com.oscarromero.tweettime.mvp.presenter.MainPresenterImpl;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar on 28/4/16.
 */
@Module(
        addsTo = AppModule.class,
        library = true,
        injects = MainActivity.class
)
public class MainModule {
    private MainPresenterView presenterView;

    public MainModule(MainPresenterView presenterView) {
        this.presenterView = presenterView;
    }

    @Provides
    public MainPresenter provideMainPresenter(Interactor<List<Tweet>> interactor) {
        return new MainPresenterImpl(presenterView, interactor);
    }
}