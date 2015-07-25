package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.PhoneSummary;
import com.harishkannarao.angularjs.model.PhoneSummaryBuilder;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class PhoneService {

    private List<PhoneSummary> phoneSummaries;

    public PhoneService() {
        PhoneSummary phoneSummary1 = new PhoneSummaryBuilder().setId(1L)
                .setName("Nexus S").setAge(1L)
                .setDescription("Fast just got faster with Nexus S.")
                .setImageUrl("/restapi/img/phones/nexus-s.0.jpg")
                .build();
        PhoneSummary phoneSummary2 = new PhoneSummaryBuilder().setId(2L)
                .setName("Motorola XOOM with Wi-Fi").setAge(2L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom.0.jpg")
                .build();
        PhoneSummary phoneSummary3 = new PhoneSummaryBuilder().setId(3L)
                .setName("MOTOROLA XOOM").setAge(3L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom-with-wi-fi.0.jpg")
                .build();

        phoneSummaries = Arrays.asList(phoneSummary1, phoneSummary2, phoneSummary3);
    }

    public List<PhoneSummary> getAllPhoneSummaries() {
        return phoneSummaries;
    }
}
