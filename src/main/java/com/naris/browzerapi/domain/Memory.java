package com.naris.browzerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Memory {
    @Id
    @JsonProperty
    private String id;
    @JsonProperty(value = "t")
    private String title;
    @JsonProperty(value = "l")
    private Location location;
    @JsonProperty(value = "i")
    private Image image;

    public Memory withImage(Image image) {
        this.image = image;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Memory withLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
