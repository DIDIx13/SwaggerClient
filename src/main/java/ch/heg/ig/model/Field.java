package ch.heg.ig.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Field {
    @JsonProperty("DefFieldID")
    private int defFieldID;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Type")
    private int type;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Value")
    private String value;

    // Constructeur
    public Field() {}

    public Field(int defFieldID, String title, int type, String code, String value) {
        this.defFieldID = defFieldID;
        this.title = title;
        this.type = type;
        this.code = code;
        this.value = value;
    }

    // Getters et Setters
    public int getDefFieldID() {
        return defFieldID;
    }

    public void setDefFieldID(int defFieldID) {
        this.defFieldID = defFieldID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // toString
    @Override
    public String toString() {
        return "Field{" +
                "defFieldID=" + defFieldID +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return defFieldID == field.defFieldID &&
                type == field.type &&
                Objects.equals(title, field.title) &&
                Objects.equals(code, field.code) &&
                Objects.equals(value, field.value);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(defFieldID, title, type, code, value);
    }
}
