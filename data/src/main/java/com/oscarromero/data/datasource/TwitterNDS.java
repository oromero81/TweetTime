package com.oscarromero.data.datasource;

import android.util.Base64;
import android.util.Log;

import com.oscarromero.data.api.TwitterApi;
import com.oscarromero.data.dto.StatusDTO;
import com.oscarromero.data.dto.TwitterResponseDTO;
import com.oscarromero.data.dto.TwitterTokenDTO;
import com.oscarromero.domain.entities.Tweet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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
        Observable<TwitterTokenDTO> token = twitterApi.getToken(TOKEN_AUTHORIZATION + encodeKeys(API_KEY, API_SECRET), "client_credentials");
        token.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TwitterTokenDTO>() {
            @Override
            public void call(TwitterTokenDTO twitterTokenDTO) {
                Log.i("TOKEN", twitterTokenDTO.getAccessToken() + " " + twitterTokenDTO.getTokenType());
                doSearch(twitterTokenDTO.getAccessToken());
            }
        });
        return null;
    }

    private void doSearch(String token) {
        Observable<TwitterResponseDTO> tweets = twitterApi.doSearch(FEED_AUTHORIZATION + token, encodeSearch());
        tweets.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TwitterResponseDTO>() {
            @Override
            public void call(TwitterResponseDTO twitterResponseDTO) {
                for (StatusDTO statusDTO : twitterResponseDTO.getStatuses()) {
                    Log.i("TW", statusDTO.getText() + "\n" + statusDTO.getCreatedAt());
                }
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
            return URLEncoder.encode("\"It's 1:21 and \"", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}