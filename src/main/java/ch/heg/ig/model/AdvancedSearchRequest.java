package ch.heg.ig.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdvancedSearchRequest {
    @JsonProperty("searchPattern")
    private String searchPattern;

    @JsonProperty("contentTypeIDs")
    private String contentTypeIDs;

    // Getters and setters
    public String getSearchPattern() {
        return searchPattern;
    }

    public void setSearchPattern(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public String getContentTypeIDs() {
        return contentTypeIDs;
    }

    public void setContentTypeIDs(String contentTypeIDs) {
        this.contentTypeIDs = contentTypeIDs;
    }
}
