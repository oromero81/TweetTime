package com.oscarromero.data.datasource;

import android.util.Base64;

import com.oscarromero.data.api.TwitterApi;
import com.oscarromero.data.dto.TwitterResponseDTO;
import com.oscarromero.data.dto.TwitterTokenDTO;
import com.oscarromero.data.mapper.ListMapper;
import com.oscarromero.data.mapper.StatusDTOMapper;
import com.oscarromero.domain.entities.Tweet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Oscar on 28/4/16.
 */
public class TwitterNDS implements NetworkDataSource<List<Tweet>> {
    private static final String API_KEY = "u0Wyewa7Y4CxAl4Aaj8QYVORt";
    private static final String API_SECRET = "42B4iorADlHgTy7321AVjMDfliNG17GLkPhHcVouGfsOwYRXK2";
    private static final String TOKEN_AUTHORIZATION = "Basic ";
    private static final String FEED_AUTHORIZATION = "Bearer ";

    private TwitterApi twitterApi;

    public TwitterNDS(TwitterApi twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public Observable<List<Tweet>> callToServer() {
        return twitterApi
                .getToken(TOKEN_AUTHORIZATION + encodeKeys(API_KEY, API_SECRET), "client_credentials")
                .subscribeOn(Schedulers.newThread())
                .switchMap(new Func1<TwitterTokenDTO, Observable<? extends TwitterResponseDTO>>() {
                    @Override
                    public Observable<? extends TwitterResponseDTO> call(TwitterTokenDTO twitterTokenDTO) {
                        return twitterApi.doSearch(FEED_AUTHORIZATION + twitterTokenDTO.getAccessToken(), encodeSearch());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<TwitterResponseDTO, List<Tweet>>() {
                    @Override
                    public List<Tweet> call(TwitterResponseDTO twitterResponseDTO) {
                        return new ListMapper<>(new StatusDTOMapper()).transform(twitterResponseDTO.getStatuses());
                    }
                });
    }

    private String encodeKeys(String consumerKey, String consumerSecret) {
        try {
            String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
            String encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");

            String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;

            byte[] encodedBytes = Base64.encode(fullKey.getBytes(), Base64.NO_WRAP);

            return new String(encodedBytes);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private String encodeSearch() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
            String time = simpleDateFormat.format(new Date());
            String search = "\"It's " + time + " and \"";

            return URLEncoder.encode(search, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}