package com.oscarromero.tweettime;

import android.app.Application;

import com.oscarromero.tweettime.di.AppModule;

import dagger.ObjectGraph;

/**
 * Created by Oscar on 28/4/16.
 */
public class TweetTimeApp extends Application {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initObjectGraph();
    }

    private void initObjectGraph() {
        objectGraph = ObjectGraph.create(new AppModule(this));
        inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    public ObjectGraph getGraph() {
        return objectGraph;
    }
}