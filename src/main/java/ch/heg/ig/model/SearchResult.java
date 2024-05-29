package ch.heg.ig.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    @JsonProperty("ObjectID")
    private int objectId;

    @JsonProperty("ContentTypeID")
    private int contentTypeId;

    @JsonProperty("ContentType")
    private String contentType;

    @JsonProperty("Author")
    private String author;

    @JsonProperty("CreationDate")
    private String creationDate;

    @JsonProperty("IsLastVersion")
    private boolean isLastVersion;

    @JsonProperty("Fields")
    private List<Field> fields;

    // Getters and setters

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isLastVersion() {
        return isLastVersion;
    }

    public void setLastVersion(boolean lastVersion) {
        isLastVersion = lastVersion;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "objectId=" + objectId +
                ", contentTypeId=" + contentTypeId +
                ", contentType='" + contentType + '\'' +
                ", author='" + author + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", isLastVersion=" + isLastVersion +
                ", fields=" + fields +
                '}';
    }
}
