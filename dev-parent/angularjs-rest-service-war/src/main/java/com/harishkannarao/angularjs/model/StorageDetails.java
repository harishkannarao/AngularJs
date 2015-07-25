package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StorageDetails {
    @JsonProperty(value = "flash")
    private String flash;
    @JsonProperty(value = "ram")
    private String ram;

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
