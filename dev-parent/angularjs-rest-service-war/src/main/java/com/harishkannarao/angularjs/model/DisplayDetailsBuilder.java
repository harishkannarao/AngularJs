package com.harishkannarao.angularjs.model;


public class DisplayDetailsBuilder {

    private String screenResolution;
    private String screenSize;
    private Boolean touchScreen;

    private DisplayDetailsBuilder() {}

    public static DisplayDetailsBuilder newBuilder() {
        return new DisplayDetailsBuilder();
    }

    public DisplayDetails build() {
        DisplayDetails result = new DisplayDetails();
        result.setScreenResolution(screenResolution);
        result.setScreenSize(screenSize);
        result.setTouchScreen(touchScreen);
        return result;
    }

    public DisplayDetailsBuilder setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
        return this;
    }

    public DisplayDetailsBuilder setScreenSize(String screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public DisplayDetailsBuilder setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
        return this;
    }
}
