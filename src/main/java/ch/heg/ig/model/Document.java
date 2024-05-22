package ch.heg.ig.model;

import java.util.List;
import java.util.Objects;

public class Document {
    private int objectID;
    private String contentType;
    private String creationDate;
    private String author;
    private List<Field> fields;

    // Constructeur
    public Document() {}

    public Document(int objectID, String contentType, String creationDate, String author, List<Field> fields) {
        this.objectID = objectID;
        this.contentType = contentType;
        this.creationDate = creationDate;
        this.author = author;
        this.fields = fields;
    }

    // Getters et Setters
    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    // toString
    @Override
    public String toString() {
        return "Document{" +
                "objectID=" + objectID +
                ", contentType='" + contentType + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", author='" + author + '\'' +
                ", fields=" + fields +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return objectID == document.objectID &&
                Objects.equals(contentType, document.contentType) &&
                Objects.equals(creationDate, document.creationDate) &&
                Objects.equals(author, document.author) &&
                Objects.equals(fields, document.fields);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(objectID, contentType, creationDate, author, fields);
    }
}
