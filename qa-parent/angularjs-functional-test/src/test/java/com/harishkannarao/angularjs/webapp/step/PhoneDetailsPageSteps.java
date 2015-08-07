package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import com.harishkannarao.angularjs.webapp.page.PhoneDetailsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class PhoneDetailsPageSteps {

    @Inject
    private PhoneDetailsPage phoneDetailsPage;

    @Inject
    private GenericPage genericPage;

    @Then("^I should be on phone details page$")
    public void I_should_be_on_phone_details_page() throws Throwable {
        assertTrue(phoneDetailsPage.isOnValidPage(), "Is not on Phone Details page. Current url is " + genericPage.getCurrentUrl());
    }

    @And("^I should see the phone id as (\\d+) on phone details page$")
    public void I_should_see_the_phone_id_as_on_phone_details_page(Long phoneId) throws Throwable {
        assertEquals(phoneDetailsPage.getPhoneId(), phoneId);
    }

    @Given("^I go to phone details page with phone id as (\\d+)$")
    public void I_go_to_phone_details_page_with_phone_id_as(Long phoneId) throws Throwable {
        phoneDetailsPage.navigate(phoneId);
    }

    @Then("^I should see the title as \"(.*)\" on phone details page$")
    public void I_should_see_the_title_as_on_phone_details_page(String pageTitle) throws Throwable {
        assertEquals(phoneDetailsPage.getTitle(), pageTitle);
    }

    @Then("^I should see the additional features as below on phone details page$")
    public void I_should_see_the_additional_features_as_below_on_phone_details_page(String additionalFeatures) throws Throwable {
        String expectedAdditionalFeatures = additionalFeatures.replaceAll("[\r\n]+", "");
        assertEquals(phoneDetailsPage.getAdditionalFeatures(), expectedAdditionalFeatures);
    }

    @Then("^I should see android os as \"(.*)\" on phone details page$")
    public void I_should_see_android_os_as_on_phone_details_page(String androidOs) throws Throwable {
        assertEquals(phoneDetailsPage.getAndroidOs(), androidOs);
    }

    @Then("^I should see android ui as \"(.*)\" on phone details page$")
    public void I_should_see_android_ui_as_on_phone_details_page(String androidUi) throws Throwable {
        assertEquals(phoneDetailsPage.getAndroidUi(), androidUi);
    }

    @Then("^I should see availability list as below on phone details page$")
    public void I_should_see_availability_list_as_below_on_phone_details_page(List<String> availabilityList) throws Throwable {
        assertEquals(phoneDetailsPage.getAvailabilityList().size(), availabilityList.size());
        assertEquals(phoneDetailsPage.getAvailabilityList(), availabilityList);
    }
}
