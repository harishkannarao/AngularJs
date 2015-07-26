package com.harishkannarao.angularjs.model;

public class StorageDetailsBuilder {
    private String flash;
    private String ram;

    private StorageDetailsBuilder() {

    }

    public static StorageDetailsBuilder newBuilder() {
        return new StorageDetailsBuilder();
    }

    public StorageDetails build() {
        StorageDetails result = new StorageDetails();
        result.setFlash(flash);
        result.setRam(ram);
        return result;
    }

    public StorageDetailsBuilder setFlash(String flash) {
        this.flash = flash;
        return this;
    }

    public StorageDetailsBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }
}
