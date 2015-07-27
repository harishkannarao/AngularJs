package com.harishkannarao.angularjs.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneBuilder {
    private String additionalFeatures;
    private AndroidOsDetails androidDetails;
    private List<String> availability;
    private BatteryDetails batteryDetails;
    private CameraDetails cameraDetails;
    private ConnectivityDetails connectivityDetails;
    private String description;
    private DisplayDetails displayDetails;
    private HardwareDetails hardwareDetails;
    private Long id;
    private List<String> images;
    private String name;
    private SizeAndWeightDetails sizeAndWeightDetails;
    private StorageDetails storageDetails;

    private PhoneBuilder() {}

    public static PhoneBuilder newBuilder() {
        return new PhoneBuilder();
    }

    public Phone build() {
        Phone result = new Phone();
        result.setAdditionalFeatures(additionalFeatures);
        result.setAndroidDetails(androidDetails);
        result.setAvailability(availability);
        result.setBatteryDetails(batteryDetails);
        result.setCameraDetails(cameraDetails);
        result.setConnectivityDetails(connectivityDetails);
        result.setDescription(description);
        result.setDisplayDetails(displayDetails);
        result.setHardwareDetails(hardwareDetails);
        result.setId(id);
        result.setImages(images);
        result.setName(name);
        result.setSizeAndWeightDetails(sizeAndWeightDetails);
        result.setStorageDetails(storageDetails);
        return result;
    }

    public PhoneBuilder setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
        return this;
    }

    public PhoneBuilder setAndroidDetails(AndroidOsDetails androidDetails) {
        this.androidDetails = androidDetails;
        return this;
    }

    public PhoneBuilder setAndroidDetails(AndroidOsDetailsBuilder androidOsDetailsBuilder) {
        return setAndroidDetails(androidOsDetailsBuilder.build());
    }

    public PhoneBuilder setAvailability(List<String> availability) {
        this.availability = availability;
        return this;
    }

    public PhoneBuilder addAvailability(String availability) {
        if(this.availability == null) {
            this.availability = new ArrayList<>();
        }
        this.availability.add(availability);
        return this;
    }

    public PhoneBuilder setBatteryDetails(BatteryDetails batteryDetails) {
        this.batteryDetails = batteryDetails;
        return this;
    }

    public PhoneBuilder setBatteryDetails(BatteryDetailsBuilder batteryDetailsBuilder) {
        return setBatteryDetails(batteryDetailsBuilder.build());
    }

    public PhoneBuilder setCameraDetails(CameraDetails cameraDetails) {
        this.cameraDetails = cameraDetails;
        return this;
    }

    public PhoneBuilder setCameraDetails(CameraDetailsBuilder cameraDetailsBuilder) {
        return setCameraDetails(cameraDetailsBuilder.build());
    }

    public PhoneBuilder setConnectivityDetails(ConnectivityDetails connectivityDetails) {
        this.connectivityDetails = connectivityDetails;
        return this;
    }

    public PhoneBuilder setConnectivityDetails(ConnectivityDetailsBuilder connectivityDetailsBuilder) {
        return setConnectivityDetails(connectivityDetailsBuilder.build());
    }

    public PhoneBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PhoneBuilder setDisplayDetails(DisplayDetails displayDetails) {
        this.displayDetails = displayDetails;
        return this;
    }

    public PhoneBuilder setDisplayDetails(DisplayDetailsBuilder displayDetailsBuilder) {
        return setDisplayDetails(displayDetailsBuilder.build());
    }

    public PhoneBuilder setHardwareDetails(HardwareDetails hardwareDetails) {
        this.hardwareDetails = hardwareDetails;
        return this;
    }

    public PhoneBuilder setHardwareDetails(HardwareDetailsBuilder hardwareDetailsBuilder) {
        return setHardwareDetails(hardwareDetailsBuilder.build());
    }

    public PhoneBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PhoneBuilder setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public PhoneBuilder addImage(String image) {
        if(this.images == null) {
            this.images = new ArrayList<>();
        }
        this.images.add(image);
        return this;
    }

    public PhoneBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PhoneBuilder setSizeAndWeightDetails(SizeAndWeightDetails sizeAndWeightDetails) {
        this.sizeAndWeightDetails = sizeAndWeightDetails;
        return this;
    }

    public PhoneBuilder setSizeAndWeightDetails(SizeAndWeightDetailsBuilder sizeAndWeightDetailsBuilder) {
        return setSizeAndWeightDetails(sizeAndWeightDetailsBuilder.build());
    }

    public PhoneBuilder setStorageDetails(StorageDetails storageDetails) {
        this.storageDetails = storageDetails;
        return this;
    }

    public PhoneBuilder setStorageDetails(StorageDetailsBuilder storageDetailsBuilder) {
        return setStorageDetails(storageDetailsBuilder.build());
    }
}
