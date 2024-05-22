package ch.heg.ig.model;

import java.util.List;

public class Document {
    private int objectId;
    private int originalId;
    private String contentType;
    private boolean isLastVersion;
    private String author;
    private List<Field> fields;

}