package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationProperties {
    @JsonProperty(value = "sampleString")
    String sampleString;
    @JsonProperty(value = "sampleStringArray")
    List<String> listOfString;
    @JsonProperty(value = "sampleLong")
    Long sampleLong;

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
}
