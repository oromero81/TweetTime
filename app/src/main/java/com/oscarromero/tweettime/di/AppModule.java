package com.oscarromero.tweettime.di;

import android.content.Context;

import com.oscarromero.tweettime.TweetTimeApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar on 28/4/16.
 */
@Module(
        includes = {
                DataModule.class, DomainModule.class
        },
        injects = TweetTimeApp.class,
        library = true
)
public class AppModule {
    private TweetTimeApp tweetTimeApp;

    public AppModule(TweetTimeApp tweetTimeApp) {
        this.tweetTimeApp = tweetTimeApp;
    }

    @Provides
    public Context provideContext() {
        return tweetTimeApp.getApplicationContext();
    }
}