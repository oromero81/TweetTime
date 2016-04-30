package com.oscarromero.data.mapper;

import com.oscarromero.data.dto.UserDTO;
import com.oscarromero.domain.entities.User;

/**
 * Created by Oscar on 30/4/16.
 */
public class UserDTOMapper implements Mapper<UserDTO, User> {
    @Override
    public User transform(UserDTO origin) {
        User user = new User();

        user.setProfileImageUrl(origin.getProfileImageUrl());
        user.setName(origin.getName());
        user.setUsername(origin.getScreenName());

        return user;
    }
}