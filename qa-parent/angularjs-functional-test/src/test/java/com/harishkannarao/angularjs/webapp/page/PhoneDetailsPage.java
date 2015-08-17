package com.harishkannarao.angularjs.webapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneDetailsPage extends BasePage{

    public void navigate(Long phoneId) {
        webDriver.navigate().to(APPLICATION_URL + "/app/index.html#/phones/" + phoneId);
        webDriver.navigate().refresh();
    }

    public boolean isOnValidPage() {
        return !webDriver.findElements(By.id("qa-phone-details-page-id")).isEmpty();
    }

    public Long getPhoneId() {
        return Long.parseLong(webDriver.findElement(By.className("qa-phone-id")).getAttribute("id"));
    }

    public String getAdditionalFeatures() {
        return webDriver.findElement(By.id("qa-phone-additional-features")).getText();
    }

    public String getAndroidOs() {
        return webDriver.findElement(By.id("qa-phone-android-os")).getText();
    }

    public String getAndroidUi() {
        return webDriver.findElement(By.id("qa-phone-android-ui")).getText();
    }

    public List<String> getAvailabilityList() {
        return webDriver.findElements(By.className("qa-phone-availability")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getStandbyTime() {
        return webDriver.findElement(By.id("qa-phone-battery-standby-time")).getText();
    }

    public String getTalkTime() {
        return webDriver.findElement(By.id("qa-phone-battery-talk-time")).getText();
    }

    public String getBatteryType() {
        return webDriver.findElement(By.id("qa-phone-battery-type")).getText();
    }

    public String getCameraFeatures() {
        return webDriver.findElement(By.id("qa-phone-features")).getText();
    }

    public String getCameraPrimary() {
        return webDriver.findElement(By.id("qa-phone-camera-primary")).getText();
    }

    public String getConnectivityBluetooth() {
        return webDriver.findElement(By.id("qa-phone-connectivity-bluetooth")).getText();
    }

    public String getConnectivityCell() {
        return webDriver.findElement(By.id("qa-phone-connectivity-cell")).getText();
    }

    public String getConnectivityGps() {
        return webDriver.findElement(By.id("qa-phone-connectivity-gps")).getText();
    }

    public String getConnectivityInfrared() {
        return webDriver.findElement(By.id("qa-phone-connectivity-infrared")).getText();
    }

    public String getConnectivityWifi() {
        return webDriver.findElement(By.id("qa-phone-connectivity-wifi")).getText();
    }

    public String getDescription() {
        return webDriver.findElement(By.id("qa-phone-description")).getText();
    }

    public String getScreenResolution() {
        return webDriver.findElement(By.id("qa-phone-screen-resolution")).getText();
    }

    public String getScreenSize() {
        return webDriver.findElement(By.id("qa-phone-screen-size")).getText();
    }

    public String getTouchScreen() {
        return webDriver.findElement(By.id("qa-phone-touch-screen")).getText();
    }

    public String getHardwareAccelerometer() {
        return webDriver.findElement(By.id("qa-phone-accelerometer")).getText();
    }

    public String getAudioJack() {
        return webDriver.findElement(By.id("qa-phone-audiojack")).getText();
    }

    public String getCpu() {
        return webDriver.findElement(By.id("qa-phone-cpu")).getText();
    }

    public String getFmRadio() {
        return webDriver.findElement(By.id("qa-phone-fmradio")).getText();
    }

    public String getUsb() {
        return webDriver.findElement(By.id("qa-phone-usb")).getText();
    }

    public List<String> getImages() {
        return webDriver.findElements(By.className("qa-phone-image")).stream().map(webElement -> webElement.getAttribute("src")).collect(Collectors.toList());
    }

    public String getPhoneName() {
        return webDriver.findElement(By.id("qa-phone-name")).getText();
    }

    public List<String> getDimensions() {
        return webDriver.findElements(By.className("qa-phone-dimensions")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getWeight() {
        return webDriver.findElement(By.id("qa-phone-weight")).getText();
    }

    public String getStorageFlash() {
        return webDriver.findElement(By.id("qa-phone-storage-flash")).getText();
    }

    public String getStorageRam() {
        return webDriver.findElement(By.id("qa-phone-storage-ram")).getText();
    }

    public String getMainImageUrl() {
        return webDriver.findElement(By.id("qa-phone-main-image")).getAttribute("src");
    }

    public void clickOnImageWithUrl(String imageUrl) {
        webDriver.findElements(By.className("qa-phone-image")).stream().filter(webElement -> imageUrl.equals(webElement.getAttribute("src"))).findFirst().get().click();
    }
}
