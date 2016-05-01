package com.oscarromero.data.repository;

import com.oscarromero.data.datasource.NetworkDataSource;
import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.repository.Repository;

import java.util.List;

import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public class TwitterRepository implements Repository<List<Tweet>> {
    private NetworkDataSource<List<Tweet>> twitterNDS;

    public TwitterRepository(NetworkDataSource<List<Tweet>> twitterNDS) {
        this.twitterNDS = twitterNDS;
    }

    @Override
    public Observable<List<Tweet>> getEntities() {
        return twitterNDS.callToServer();
    }
}