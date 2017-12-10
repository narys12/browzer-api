package com.naris.browzerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Memory {
    @Id
    @JsonProperty
    private String id;
    @JsonProperty(required = true, value = "t")
    private String title;
    @JsonProperty(value = "pc")
    private Long picturesCount = 0l;
    @JsonProperty(value = "l")
    private Location location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPicturesCount() {
        return picturesCount;
    }

    public void setPicturesCount(Long picturesCount) {
        this.picturesCount = picturesCount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
