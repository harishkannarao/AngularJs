package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.*;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class PhoneService {

    private List<PhoneSummary> phoneSummaries;
    private Map<Long, Phone> phones;

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
                .setDescription("Nexus S is the next generation of Nexus devices, co-developed by Google and Samsung. The latest Android platform (Gingerbread), paired with a 1 GHz Hummingbird processor and 16GB of memory, makes Nexus S one of the fastest phones on the market. It comes pre-installed with the best of Google apps and enabled with new and popular features like true multi-tasking, Wi-Fi hotspot, Internet Calling, NFC support, and full web browsing. With this device, users will also be the first to receive software upgrades and new Google mobile apps as soon as they become available. For more details, visit http://www.google.com/nexus.")
                .setDisplayDetails(
                        DisplayDetailsBuilder.newBuilder()
                                .setScreenResolution("WVGA (800 x 480)")
                                .setScreenSize("4.0 inches")
                                .setTouchScreen(true))
                .setHardwareDetails(
                        HardwareDetailsBuilder.newBuilder()
                                .setAccelerometer(true)
                                .setAudioJack("3.5mm")
                                .setCpu("1GHz Cortex A8 (Hummingbird) processor")
                                .setFmRadio(false)
                                .setPhysicalKeyboard(false)
                                .setUsb("USB 2.0")
                )
                .setId(1L)
                .setImages(
                        Arrays.asList(
                                "/restapi/img/phones/nexus-s.0.jpg",
                                "/restapi/img/phones/nexus-s.1.jpg",
                                "/restapi/img/phones/nexus-s.2.jpg",
                                "/restapi/img/phones/nexus-s.3.jpg"
                        )
                )
                .setName("Nexus S")
                .setSizeAndWeightDetails(
                        SizeAndWeightDetailsBuilder.newBuilder()
                                .setDimensions(Arrays.asList("63.0 mm (w)", "123.9 mm (h)", "10.88 mm (d)"))
                                .setWeight("129.0 grams")
                )
                .setStorageDetails(
                        StorageDetailsBuilder.newBuilder()
                                .setFlash("16384MB")
                                .setRam("512MB")
                )
                .build();

        phones = Arrays.asList(nexusSPhone).stream().collect(Collectors.toMap(Phone::getId, (Phone phone) -> phone));
    }

    public List<PhoneSummary> getAllPhoneSummaries() {
        return phoneSummaries;
    }

    public Optional<Phone> getPhoneById(Long id) {
        return Optional.ofNullable(phones.get(id));
    }
}
