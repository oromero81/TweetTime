package com.oscarromero.data.mapper;

import com.oscarromero.data.dto.StatusDTO;
import com.oscarromero.domain.entities.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Oscar on 30/4/16.
 */
public class StatusDTOMapper implements Mapper<StatusDTO, Tweet> {
    @Override
    public Tweet transform(StatusDTO origin) {
        Tweet tweet = new Tweet();

        tweet.setUser(new UserDTOMapper().transform(origin.getUser()));

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE LLL dd HH:mm:ss Z yyyy");
            tweet.setCreateAt(formatter.parse(origin.getCreatedAt()));
        } catch (ParseException e) {
            tweet.setCreateAt(new Date());
        }
        tweet.setMessage(origin.getText());
        tweet.setRetweets(origin.getRetweetCount());

        return tweet;
    }
}