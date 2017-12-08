package com.naris.browzerapi.domain;

import org.springframework.data.annotation.Id;

public class Memory {
    @Id
    private String id;
    private String title;
    private Long picturesCount = 0l;
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
