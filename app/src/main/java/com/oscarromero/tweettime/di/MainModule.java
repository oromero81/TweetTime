package com.oscarromero.tweettime.di;

import com.oscarromero.tweettime.MainActivity;
import com.oscarromero.tweettime.mvp.presenter.MainPresenter;
import com.oscarromero.tweettime.mvp.view.MainPresenterView;

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

}