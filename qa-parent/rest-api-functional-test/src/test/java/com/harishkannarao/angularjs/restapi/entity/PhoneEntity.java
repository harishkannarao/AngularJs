package com.harishkannarao.angularjs.restapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PhoneEntity {

    @JsonProperty(value = "additionalFeatures")
    private String additionalFeatures;
    @JsonProperty(value = "android")
    private AndroidDetails androidDetails;
    @JsonProperty(value = "availability")
    private List<String> availabilityList;
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

    public AndroidDetails getAndroidDetails() {
        return androidDetails;
    }

    public void setAndroidDetails(AndroidDetails androidDetails) {
        this.androidDetails = androidDetails;
    }

    public List<String> getAvailabilityList() {
        return availabilityList;
    }

    public void setAvailabilityList(List<String> availabilityList) {
        this.availabilityList = availabilityList;
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

    public static class AndroidDetails {
        @JsonProperty(value = "os")
        private String os;
        @JsonProperty(value = "ui")
        private String ui;

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getUi() {
            return ui;
        }

        public void setUi(String ui) {
            this.ui = ui;
        }
    }

    public static class BatteryDetails {
        @JsonProperty(value = "standbyTime")
        private String standbyTime;
        @JsonProperty(value = "talkTime")
        private String talkTime;
        @JsonProperty(value = "type")
        private String type;

        public String getStandbyTime() {
            return standbyTime;
        }

        public void setStandbyTime(String standbyTime) {
            this.standbyTime = standbyTime;
        }

        public String getTalkTime() {
            return talkTime;
        }

        public void setTalkTime(String talkTime) {
            this.talkTime = talkTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class CameraDetails {
        @JsonProperty(value = "features")
        private List<String> features;
        @JsonProperty(value = "primary")
        private String primary;

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public String getPrimary() {
            return primary;
        }

        public void setPrimary(String primary) {
            this.primary = primary;
        }
    }

    public static class ConnectivityDetails {
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

    public static class DisplayDetails {
        @JsonProperty(value = "screenResolution")
        private String screenResolution;
        @JsonProperty(value = "screenSize")
        private String screenSize;
        @JsonProperty(value = "touchScreen")
        private Boolean touchScreen;

        public String getScreenResolution() {
            return screenResolution;
        }

        public void setScreenResolution(String screenResolution) {
            this.screenResolution = screenResolution;
        }

        public String getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(String screenSize) {
            this.screenSize = screenSize;
        }

        public Boolean getTouchScreen() {
            return touchScreen;
        }

        public void setTouchScreen(Boolean touchScreen) {
            this.touchScreen = touchScreen;
        }
    }

    public static class HardwareDetails {
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

    public static class SizeAndWeightDetails {
        @JsonProperty(value = "dimensions")
        private List<String> dimensions;
        @JsonProperty(value = "weight")
        private String weight;

        public List<String> getDimensions() {
            return dimensions;
        }

        public void setDimensions(List<String> dimensions) {
            this.dimensions = dimensions;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
    }

    public static class StorageDetails {
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
}
