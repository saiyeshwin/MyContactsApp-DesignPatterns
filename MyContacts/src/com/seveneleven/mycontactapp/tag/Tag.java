package com.seveneleven.mycontactapp.tag;
import java.util.Objects;
public class Tag {
    private String name;
    Tag(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tag name cannot be empty");
        }
        this.name = name.toLowerCase();
    }
    public String getName() {
        return name;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tag tag = (Tag) obj;
        return Objects.equals(name, tag.name);
    }
    public int hashCode() {
        return Objects.hash(name);
    }
    public String toString() {
        return name;
    }
}