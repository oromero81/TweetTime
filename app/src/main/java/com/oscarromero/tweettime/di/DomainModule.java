package com.oscarromero.tweettime.di;

import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.interactor.GetTweetsInteractor;
import com.oscarromero.domain.interactor.Interactor;
import com.oscarromero.domain.repository.Repository;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar on 28/4/16.
 */
@Module(
        complete = false,
        library = true
)
public class DomainModule {

    @Provides
    public Interactor<List<Tweet>> provideInteractor(Repository<List<Tweet>> repository){
        return new GetTweetsInteractor(repository);
    }
}
