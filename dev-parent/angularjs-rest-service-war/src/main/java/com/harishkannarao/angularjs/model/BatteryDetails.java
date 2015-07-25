package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatteryDetails {
    @JsonProperty(value = "standbyTime")
    private String standbyTime;
    @JsonProperty(value = "talkTime")
    private String talkTime;
    @JsonProperty(value = "type")
    private String type;

    public String getStandbyTime() {
        return standbyTime;
    }

    public void setStandbyTime(String standbyTime) {
        this.standbyTime = standbyTime;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
