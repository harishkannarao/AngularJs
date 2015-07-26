package com.harishkannarao.angularjs.model;

public class BatteryDetailsBuilder {
    private String standbyTime;
    private String talkTime;
    private String type;

    private BatteryDetailsBuilder() {

    }

    public static BatteryDetailsBuilder newBuilder() {
        return new BatteryDetailsBuilder();
    }

    public BatteryDetails build() {
        BatteryDetails result = new BatteryDetails();
        result.setStandbyTime(this.standbyTime);
        result.setTalkTime(this.talkTime);
        result.setType(this.type);
        return result;
    }

    public BatteryDetailsBuilder setStandbyTime(String standbyTime) {
        this.standbyTime = standbyTime;
        return this;
    }

    public BatteryDetailsBuilder setTalkTime(String talkTime) {
        this.talkTime = talkTime;
        return this;
    }

    public BatteryDetailsBuilder setType(String type) {
        this.type = type;
        return this;
    }
}
