package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationProperties {
    @JsonProperty(value = "sampleString")
    private String sampleString;
    @JsonProperty(value = "sampleStringArray")
    private List<String> listOfString;
    @JsonProperty(value = "sampleLong")
    private Long sampleLong;
    @JsonProperty(value = "enablePropertyChangeListener")
    private Boolean enablePropertyChangeListener;

    public String getSampleString() {
        return sampleString;
    }

    public void setSampleString(String sampleString) {
        this.sampleString = sampleString;
    }

    public Long getSampleLong() {
        return sampleLong;
    }

    public void setSampleLong(Long sampleLong) {
        this.sampleLong = sampleLong;
    }

    public List<String> getListOfString() {
        return listOfString;
    }

    public void setListOfString(List<String> listOfString) {
        this.listOfString = listOfString;
    }

    public Boolean getEnablePropertyChangeListener() {
        return enablePropertyChangeListener;
    }

    public void setEnablePropertyChangeListener(Boolean enablePropertyChangeListener) {
        this.enablePropertyChangeListener = enablePropertyChangeListener;
    }
}
