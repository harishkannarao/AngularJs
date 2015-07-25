package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SizeAndWeightDetails {
    @JsonProperty(value = "dimensions")
    private List<String> dimensions;
    @JsonProperty(value = "weight")
    private String weight;

    public List<String> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
