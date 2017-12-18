package com.naris.browzerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Picture {
    @Id
    private String id;
    @JsonProperty(value = "l")
    private Location location;
    @JsonProperty(value = "mId")
    private String memoryId;
    @JsonProperty(value = "i")
    private Image image;
    @JsonProperty(value = "ca")
    private String createdAt;

    public Location getLocation() {
        return location;
    }

    public Picture withLocation(Location location) {
        this.location = location;
        return this;
    }

    public Picture withMemoryId(String memoryId) {
        this.memoryId = memoryId;
        return this;
    }

    public Picture withImage(Image image) {
        this.image = image;
        return this;
    }

    public Picture withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
