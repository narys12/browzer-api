package com.naris.browzerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    @JsonProperty(value = "src")
    private String src;
    @JsonProperty(value = "alt")
    private String alt;
}
