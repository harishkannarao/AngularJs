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
        Phone phone1 = new PhoneBuilder().setName("Nexus S").setAge(1L).setSnippet("Fast just got faster with Nexus S.").build();
        Phone phone2 = new PhoneBuilder().setName("Motorola XOOM with Wi-Fi").setAge(2L).setSnippet("The Next, Next Generation tablet.").build();
        Phone phone3 = new PhoneBuilder().setName("MOTOROLA XOOM").setAge(3L).setSnippet("The Next, Next Generation tablet.").build();

        phones = Arrays.asList(phone1, phone2, phone3);
    }

    public List<Phone> getAllPhones() {
        return phones;
    }
}
