package com.oscarromero.domain.interactor;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.repository.Repository;

import java.util.List;

import rx.Observable;

/**
 * Created by Oscar on 28/4/16.
 */
public class GetTweetsInteractor implements Interactor<List<Tweet>> {
    private Repository<List<Tweet>> twitterRepository;

    public GetTweetsInteractor(Repository<List<Tweet>> twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    @Override
    public Observable<List<Tweet>> run() {
        return twitterRepository.getEntities();
    }
}