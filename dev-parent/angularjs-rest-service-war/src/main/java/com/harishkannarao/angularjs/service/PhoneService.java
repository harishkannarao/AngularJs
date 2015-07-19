package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.Phone;
import com.harishkannarao.angularjs.model.PhoneBuilder;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class PhoneService {

    private List<Phone> phones;

    public PhoneService() {
        Phone phone1 = new PhoneBuilder().setId(1L)
                .setName("Nexus S").setAge(1L)
                .setDescription("Fast just got faster with Nexus S.")
                .setImageUrl("/restapi/img/phones/nexus-s.0.jpg")
                .build();
        Phone phone2 = new PhoneBuilder().setId(2L)
                .setName("Motorola XOOM with Wi-Fi").setAge(2L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom.0.jpg")
                .build();
        Phone phone3 = new PhoneBuilder().setId(3L)
                .setName("MOTOROLA XOOM").setAge(3L)
                .setDescription("The Next, Next Generation tablet.")
                .setImageUrl("/restapi/img/phones/motorola-xoom-with-wi-fi.0.jpg")
                .build();

        phones = Arrays.asList(phone1, phone2, phone3);
    }

    public List<Phone> getAllPhones() {
        return phones;
    }
}
