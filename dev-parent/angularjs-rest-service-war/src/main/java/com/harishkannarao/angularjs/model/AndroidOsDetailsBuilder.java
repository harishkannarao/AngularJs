package com.harishkannarao.angularjs.model;

public class AndroidOsDetailsBuilder {
    private String os;
    private String ui;

    private AndroidOsDetailsBuilder() {
    }

    public static AndroidOsDetailsBuilder newBuilder() {
        return new AndroidOsDetailsBuilder();
    }

    public AndroidOsDetails build() {
        AndroidOsDetails result = new AndroidOsDetails();
        result.setOs(this.os);
        result.setUi(this.ui);
        return result;
    }

    public AndroidOsDetailsBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public AndroidOsDetailsBuilder setUi(String ui) {
        this.ui = ui;
        return this;
    }
}
