package com.oscarromero.data.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oscar on 28/4/16.
 */
public class TwitterTokenDTO {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}