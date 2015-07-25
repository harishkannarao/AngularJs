package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CameraDetails {
    @JsonProperty(value = "features")
    private List<String> features;
    @JsonProperty(value = "primary")
    private String primary;

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
}
