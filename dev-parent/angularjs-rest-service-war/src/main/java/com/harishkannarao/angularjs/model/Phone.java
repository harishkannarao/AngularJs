package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Phone {
    @JsonProperty(value = "additionalFeatures")
    private String additionalFeatures;
    @JsonProperty(value = "android")
    private AndroidOsDetails androidDetails;
    @JsonProperty(value = "availability")
    private List<String> availability;
}
