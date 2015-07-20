package com.harishkannarao.angularjs.webapp.step;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhoneDetailsPageSteps {

    @Then("^I should be on phone details page$")
    public void I_should_be_on_phone_details_page() throws Throwable {
//        // Express the Regexp above with the code you wish you had
//        throw new PendingException();
    }

    @And("^I should see the phone id as (\\d+) on phone details page$")
    public void I_should_see_the_phone_id_as_on_phone_details_page(Long phoneId) throws Throwable {
//        // Express the Regexp above with the code you wish you had
//        throw new PendingException();
    }
}
