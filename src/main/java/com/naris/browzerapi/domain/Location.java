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
}
