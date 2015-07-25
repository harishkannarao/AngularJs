package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Phone {
    @JsonProperty(value = "additionalFeatures")
    private String additionalFeatures;
    @JsonProperty(value = "android")
    private AndroidOsDetails androidDetails;
    @JsonProperty(value = "availability")
    private List<String> availability;
    @JsonProperty(value = "battery")
    private BatteryDetails batteryDetails;
    @JsonProperty(value = "camera")
    private CameraDetails cameraDetails;
    @JsonProperty(value = "connectivity")
    private ConnectivityDetails connectivityDetails;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "display")
    private DisplayDetails displayDetails;
    @JsonProperty(value = "hardware")
    private HardwareDetails hardwareDetails;
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "images")
    private List<String> images;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "sizeAndWeight")
    private SizeAndWeightDetails sizeAndWeightDetails;
    @JsonProperty(value = "storage")
    private StorageDetails storageDetails;

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }

    public AndroidOsDetails getAndroidDetails() {
        return androidDetails;
    }

    public void setAndroidDetails(AndroidOsDetails androidDetails) {
        this.androidDetails = androidDetails;
    }

    public List<String> getAvailability() {
        return availability;
    }

    public void setAvailability(List<String> availability) {
        this.availability = availability;
    }

    public BatteryDetails getBatteryDetails() {
        return batteryDetails;
    }

    public void setBatteryDetails(BatteryDetails batteryDetails) {
        this.batteryDetails = batteryDetails;
    }

    public CameraDetails getCameraDetails() {
        return cameraDetails;
    }

    public void setCameraDetails(CameraDetails cameraDetails) {
        this.cameraDetails = cameraDetails;
    }

    public ConnectivityDetails getConnectivityDetails() {
        return connectivityDetails;
    }

    public void setConnectivityDetails(ConnectivityDetails connectivityDetails) {
        this.connectivityDetails = connectivityDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DisplayDetails getDisplayDetails() {
        return displayDetails;
    }

    public void setDisplayDetails(DisplayDetails displayDetails) {
        this.displayDetails = displayDetails;
    }

    public HardwareDetails getHardwareDetails() {
        return hardwareDetails;
    }

    public void setHardwareDetails(HardwareDetails hardwareDetails) {
        this.hardwareDetails = hardwareDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SizeAndWeightDetails getSizeAndWeightDetails() {
        return sizeAndWeightDetails;
    }

    public void setSizeAndWeightDetails(SizeAndWeightDetails sizeAndWeightDetails) {
        this.sizeAndWeightDetails = sizeAndWeightDetails;
    }

    public StorageDetails getStorageDetails() {
        return storageDetails;
    }

    public void setStorageDetails(StorageDetails storageDetails) {
        this.storageDetails = storageDetails;
    }
}
