package com.oscarromero.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oscar on 29/4/16.
 */
public class SearchMetadataDTO {
    @SerializedName("completed_in")
    @Expose
    private Double completedIn;
    @SerializedName("max_id")
    @Expose
    private Long maxId;
    @SerializedName("max_id_str")
    @Expose
    private String maxIdStr;
    @SerializedName("next_results")
    @Expose
    private String nextResults;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("refresh_url")
    @Expose
    private String refreshUrl;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("since_id")
    @Expose
    private Integer sinceId;
    @SerializedName("since_id_str")
    @Expose
    private String sinceIdStr;

    public Double getCompletedIn() {
        return completedIn;
    }

    public void setCompletedIn(Double completedIn) {
        this.completedIn = completedIn;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public String getMaxIdStr() {
        return maxIdStr;
    }

    public void setMaxIdStr(String maxIdStr) {
        this.maxIdStr = maxIdStr;
    }

    public String getNextResults() {
        return nextResults;
    }

    public void setNextResults(String nextResults) {
        this.nextResults = nextResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSinceId() {
        return sinceId;
    }

    public void setSinceId(Integer sinceId) {
        this.sinceId = sinceId;
    }

    public String getSinceIdStr() {
        return sinceIdStr;
    }

    public void setSinceIdStr(String sinceIdStr) {
        this.sinceIdStr = sinceIdStr;
    }
}