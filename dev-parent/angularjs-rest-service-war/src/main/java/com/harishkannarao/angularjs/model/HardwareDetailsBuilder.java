package com.harishkannarao.angularjs.model;

public class HardwareDetailsBuilder {
    private Boolean accelerometer;
    private String audioJack;
    private String cpu;
    private Boolean fmRadio;
    private Boolean physicalKeyboard;
    private String usb;

    private HardwareDetailsBuilder() {

    }

    public static HardwareDetailsBuilder newBuilder() {
        return new HardwareDetailsBuilder();
    }

    public HardwareDetails build() {
        HardwareDetails result = new HardwareDetails();
        result.setAccelerometer(accelerometer);
        result.setAudioJack(audioJack);
        result.setCpu(cpu);
        result.setFmRadio(fmRadio);
        result.setPhysicalKeyboard(physicalKeyboard);
        result.setUsb(usb);

        return result;
    }

    public HardwareDetailsBuilder setAccelerometer(Boolean accelerometer) {
        this.accelerometer = accelerometer;
        return this;
    }

    public HardwareDetailsBuilder setAudioJack(String audioJack) {
        this.audioJack = audioJack;
        return this;
    }

    public HardwareDetailsBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public HardwareDetailsBuilder setFmRadio(Boolean fmRadio) {
        this.fmRadio = fmRadio;
        return this;
    }

    public HardwareDetailsBuilder setPhysicalKeyboard(Boolean physicalKeyboard) {
        this.physicalKeyboard = physicalKeyboard;
        return this;
    }

    public HardwareDetailsBuilder setUsb(String usb) {
        this.usb = usb;
        return this;
    }
}
