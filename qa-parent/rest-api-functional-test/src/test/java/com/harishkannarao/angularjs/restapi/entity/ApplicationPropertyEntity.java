package com.harishkannarao.angularjs.restapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationPropertyEntity {
    @JsonProperty(value = "sampleString")
    String sampleString;
    @JsonProperty(value = "sampleStringArray")
    List<String> listOfString;
    @JsonProperty(value = "sampleLong")
    Long sampleLong;
    @JsonProperty(value = "enablePropertyChangeListener")
    private Boolean enablePropertyChangeListener;

    public String getSampleString() {
        return sampleString;
    }

    public void setSampleString(String sampleString) {
        this.sampleString = sampleString;
    }

    public List<String> getListOfString() {
        return listOfString;
    }

    public void setListOfString(List<String> listOfString) {
        this.listOfString = listOfString;
    }

    public Long getSampleLong() {
        return sampleLong;
    }

    public void setSampleLong(Long sampleLong) {
        this.sampleLong = sampleLong;
    }

    public Boolean getEnablePropertyChangeListener() {
        return enablePropertyChangeListener;
    }

    public void setEnablePropertyChangeListener(Boolean enablePropertyChangeListener) {
        this.enablePropertyChangeListener = enablePropertyChangeListener;
    }
}
