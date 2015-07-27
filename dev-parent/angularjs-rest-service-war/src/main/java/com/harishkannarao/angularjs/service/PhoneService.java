package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.*;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class PhoneService {

    private List<PhoneSummary> phoneSummaries;
    private List<Phone> phones;

    public PhoneService() {
        PhoneSummary nexusSPhoneSummary = new PhoneSummaryBuilder().setId(1L)
                .setName("Nexus S").setAge(1L)
                .setDescription("Fast just got faster with Nexus S.")
                .setImageUrl("/restapi/img/phones/nexus-s.0.jpg")
                .build();
        PhoneSummary motorolaXoomWifiPhoneSummary = new PhoneSummaryBuilder().setId(2L)
                .setName("Motorola XOOM with Wi-Fi").setAge(2L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom.0.jpg")
                .build();
        PhoneSummary motorolaXoomphoneSummary = new PhoneSummaryBuilder().setId(3L)
                .setName("MOTOROLA XOOM").setAge(3L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom-with-wi-fi.0.jpg")
                .build();

        phoneSummaries = Arrays.asList(nexusSPhoneSummary, motorolaXoomWifiPhoneSummary, motorolaXoomphoneSummary);

        Phone nexusSPhone = PhoneBuilder.newBuilder()
                .setAdditionalFeatures("Contour Display, Near Field Communications (NFC), Three-axis gyroscope, Anti-fingerprint display coating, Internet Calling support (VoIP/SIP)")
                .setAndroidDetails(
                        AndroidOsDetailsBuilder.newBuilder()
                                .setOs("Android 2.3")
                                .setUi("Android"))
                .setAvailability(Arrays.asList("M1", "O2", "Orange", "Singtel", "StarHub", "T-Mobile", "Vodafone"))
                .setBatteryDetails(
                        BatteryDetailsBuilder.newBuilder()
                                .setStandbyTime("428 hours")
                                .setTalkTime("6 hours")
                                .setType("Lithium Ion (Li-Ion) (1500 mAH)"))
                .setCameraDetails(
                        CameraDetailsBuilder.newBuilder()
                                .setFeatures(Arrays.asList("Flash", "Video"))
                                .setPrimary("5.0 megapixels"))
                .setConnectivityDetails(
                        ConnectivityDetailsBuilder.newBuilder()
                                .setBluetooth("Bluetooth 2.1")
                                .setCell("Quad-band GSM: 850, 900, 1800, 1900\r\nTri-band HSPA: 900, 2100, 1700\r\nHSPA type: HSDPA (7.2Mbps) HSUPA (5.76Mbps)")
                                .setGps(true)
                                .setInfrared(false)
                                .setWifi("802.11 b/g/n"))
                .build();

    }

    public List<PhoneSummary> getAllPhoneSummaries() {
        return phoneSummaries;
    }
}
