package com.harishkannarao.angularjs.model;

public class ConnectivityDetailsBuilder {

    private String bluetooth;
    private String cell;
    private Boolean gps;
    private Boolean infrared;
    private String wifi;


    private ConnectivityDetailsBuilder() {

    }

    public static ConnectivityDetailsBuilder newBuilder() {
        return new ConnectivityDetailsBuilder();
    }

    public ConnectivityDetails build() {
        ConnectivityDetails result = new ConnectivityDetails();
        result.setBluetooth(this.bluetooth);
        result.setCell(this.cell);
        result.setGps(this.gps);
        result.setInfrared(this.infrared);
        result.setWifi(this.wifi);
        return result;
    }

    public ConnectivityDetailsBuilder setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public ConnectivityDetailsBuilder setCell(String cell) {
        this.cell = cell;
        return this;
    }

    public ConnectivityDetailsBuilder setGps(Boolean gps) {
        this.gps = gps;
        return this;
    }

    public ConnectivityDetailsBuilder setInfrared(Boolean infrared) {
        this.infrared = infrared;
        return this;
    }

    public ConnectivityDetailsBuilder setWifi(String wifi) {
        this.wifi = wifi;
        return this;
    }
}
