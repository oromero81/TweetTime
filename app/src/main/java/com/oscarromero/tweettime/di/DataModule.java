package com.oscarromero.tweettime.di;


import com.oscarromero.data.api.TwitterApi;
import com.oscarromero.data.datasource.NetworkDataSource;
import com.oscarromero.data.datasource.TwitterNDS;
import com.oscarromero.data.repository.TwitterRepository;
import com.oscarromero.domain.entities.Tweet;
import com.oscarromero.domain.repository.Repository;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Oscar on 28/4/16.
 */
@Module(
        complete = false,
        library = true
)
public class DataModule {
    private static final String ENDPOINT = "https://api.twitter.com";

    @Provides
    public TwitterApi provideTwitterApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(TwitterApi.class);
    }

    @Provides
    public NetworkDataSource<List<Tweet>> provideNetworkDataSource(TwitterApi twitterApi) {
        return new TwitterNDS(twitterApi);
    }

    @Provides
    public Repository<List<Tweet>> provideRepository(NetworkDataSource<List<Tweet>> networkDataSource){
        return new TwitterRepository(networkDataSource);
    }
}