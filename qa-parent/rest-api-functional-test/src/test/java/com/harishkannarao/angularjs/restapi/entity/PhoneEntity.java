package com.harishkannarao.angularjs.restapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PhoneEntity {

    @JsonProperty(value = "additionalFeatures")
    private String additionalFeatures;
    @JsonProperty(value = "android")
    private AndroidDetails androidDetails;
    @JsonProperty(value = "availability")
    private List<String> availabilityList;
    @JsonProperty(value = "battery")
    private BatteryDetails batteryDetails;

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }

    public AndroidDetails getAndroidDetails() {
        return androidDetails;
    }

    public void setAndroidDetails(AndroidDetails androidDetails) {
        this.androidDetails = androidDetails;
    }

    public List<String> getAvailabilityList() {
        return availabilityList;
    }

    public void setAvailabilityList(List<String> availabilityList) {
        this.availabilityList = availabilityList;
    }

    public BatteryDetails getBatteryDetails() {
        return batteryDetails;
    }

    public void setBatteryDetails(BatteryDetails batteryDetails) {
        this.batteryDetails = batteryDetails;
    }

    public static class AndroidDetails {
        @JsonProperty(value = "os")
        private String os;
        @JsonProperty(value = "ui")
        private String ui;

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getUi() {
            return ui;
        }

        public void setUi(String ui) {
            this.ui = ui;
        }
    }

    public static class BatteryDetails {
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
}
