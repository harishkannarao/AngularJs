package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayDetails {
    @JsonProperty(value = "screenResolution")
    private String screenResolution;
    @JsonProperty(value = "screenSize")
    private String screenSize;
    @JsonProperty(value = "touchScreen")
    private Boolean touchScreen;
}
