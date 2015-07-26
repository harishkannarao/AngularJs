package com.harishkannarao.angularjs.model;

import java.util.ArrayList;
import java.util.List;

public class SizeAndWeightDetailsBuilder {
    private List<String> dimensions;
    private String weight;


    private SizeAndWeightDetailsBuilder() {

    }

    public static SizeAndWeightDetailsBuilder newBuilder() {
        return new SizeAndWeightDetailsBuilder();
    }

    public SizeAndWeightDetails build() {
        SizeAndWeightDetails result = new SizeAndWeightDetails();
        result.setDimensions(dimensions);
        result.setWeight(weight);
        return result;
    }

    public SizeAndWeightDetailsBuilder setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public SizeAndWeightDetailsBuilder addDimension(String dimension) {
        if(this.dimensions == null) {
            this.dimensions = new ArrayList<>();
        }
        this.dimensions.add(dimension);
        return this;
    }

    public SizeAndWeightDetailsBuilder setWeight(String weight) {
        this.weight = weight;
        return this;
    }
}
