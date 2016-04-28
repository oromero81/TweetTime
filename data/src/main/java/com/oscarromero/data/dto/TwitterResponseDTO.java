package com.oscarromero.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 29/4/16.
 */
public class TwitterResponseDTO {
    @SerializedName("statuses")
    @Expose
    private List<StatusDTO> statuses = new ArrayList<>();
    @SerializedName("search_metadata")
    @Expose
    private SearchMetadataDTO searchMetadata;

    public List<StatusDTO> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusDTO> statuses) {
        this.statuses = statuses;
    }

    public SearchMetadataDTO getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadataDTO searchMetadata) {
        this.searchMetadata = searchMetadata;
    }
}