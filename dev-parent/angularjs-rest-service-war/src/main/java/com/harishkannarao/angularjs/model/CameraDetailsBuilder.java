package com.harishkannarao.angularjs.model;

import java.util.ArrayList;
import java.util.List;

public class CameraDetailsBuilder {

    private List<String> features;
    private String primary;

    private CameraDetailsBuilder() {}

    public static CameraDetailsBuilder newBuilder() {
        return new CameraDetailsBuilder();
    }

    public CameraDetails build() {
        CameraDetails result = new CameraDetails();
        result.setFeatures(this.features);
        result.setPrimary(this.primary);
        return result;
    }

    public CameraDetailsBuilder setFeatures(List<String> features) {
        this.features = features;
        return this;
    }

    public CameraDetailsBuilder addFeature(String feature) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(feature);
        return this;
    }

    public CameraDetailsBuilder setPrimary(String primary) {
        this.primary = primary;
        return this;
    }
}
