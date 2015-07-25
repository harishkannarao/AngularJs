package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectivityDetails {
    @JsonProperty(value = "bluetooth")
    private String bluetooth;
    @JsonProperty(value = "cell")
    private String cell;
    @JsonProperty(value = "gps")
    private Boolean gps;
    @JsonProperty(value = "infrared")
    private Boolean infrared;
    @JsonProperty(value = "wifi")
    private String wifi;

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    public Boolean getInfrared() {
        return infrared;
    }

    public void setInfrared(Boolean infrared) {
        this.infrared = infrared;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
}
