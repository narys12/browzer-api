package com.naris.browzerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty(value = "lat")
    private String latitude;
    @JsonProperty(value = "long")
    private String longitude;
    @JsonProperty(value = "p")
    private String place;
    @JsonProperty(value = "c")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
