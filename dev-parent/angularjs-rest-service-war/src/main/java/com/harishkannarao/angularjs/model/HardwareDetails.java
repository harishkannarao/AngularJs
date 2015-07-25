package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HardwareDetails {
    @JsonProperty(value = "accelerometer")
    private Boolean accelerometer;
    @JsonProperty(value = "audioJack")
    private String audioJack;
    @JsonProperty(value = "cpu")
    private String cpu;
    @JsonProperty(value = "fmRadio")
    private Boolean fmRadio;
    @JsonProperty(value = "physicalKeyboard")
    private Boolean physicalKeyboard;
    @JsonProperty(value = "usb")
    private String usb;

    public Boolean getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(Boolean accelerometer) {
        this.accelerometer = accelerometer;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Boolean getFmRadio() {
        return fmRadio;
    }

    public void setFmRadio(Boolean fmRadio) {
        this.fmRadio = fmRadio;
    }

    public Boolean getPhysicalKeyboard() {
        return physicalKeyboard;
    }

    public void setPhysicalKeyboard(Boolean physicalKeyboard) {
        this.physicalKeyboard = physicalKeyboard;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }
}
