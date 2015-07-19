package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.PhoneListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class PhoneListPageSteps {

    @Inject
    private PhoneListPage phoneListPage;

    @Given("^I go to phone list page$")
    public void I_go_to_phone_list_page() throws Throwable {
        phoneListPage.navigate();
        phoneListPage.waitForAngularRequestsToFinish();
    }

    @Then("^I should see total number of phones as (\\d+) on phone list page$")
    public void I_should_see_total_number_of_phones_as_on_index_page(int phoneCount) throws Throwable {
        assertEquals(phoneListPage.getPhoneCount(), phoneCount);
    }

    @When("^I enter query as (.*) on phone list page$")
    public void I_enter_query_as_on_index_page(String query) throws Throwable {
        phoneListPage.enterQuery(query);
    }

    @Then("^I should see the name as (.*) on phone list page")
    public void I_should_see_the_name_as(String expectedName) throws Throwable {
        assertEquals(phoneListPage.getName(), expectedName);
    }

    @Then("^I should see the title as (.*) on phone list page$")
    public void I_should_see_the_title_as_on_index_page(String expectedTitle) throws Throwable {
        assertEquals(phoneListPage.getTitle(), expectedTitle);
    }

    @Then("^I should see the value of sort by as (.*) on phone list page$")
    public void I_should_see_the_value_of_sort_by_as_on_index_page(String sortByValue) throws Throwable {
        assertEquals(phoneListPage.getSortByValue(), sortByValue);
    }

    @When("^I set sort by as (.*) on phone list page$")
    public void I_set_sort_by_as_on_index_page(String sortByValue) throws Throwable {
        phoneListPage.setSortByValue(sortByValue);
    }

    @Then("^I should see the list of phone names as below on phone list page$")
    public void I_should_see_the_list_of_phone_names_as_below_on_index_page(List<String> expectedPhoneNames) throws Throwable {
        assertEquals(phoneListPage.getDisplayedPhoneNames(), expectedPhoneNames);
    }

    @Then("^I should see the list of phone snippet as below on phone list page$")
    public void I_should_see_the_list_of_phone_snippet_as_below_on_index_page(List<String> expectedPhoneSnippets) throws Throwable {
        assertEquals(phoneListPage.getDisplayedPhoneSnippets(), expectedPhoneSnippets);
    }

    @Then("^I should see image for every phone on phone list page$")
    public void I_should_see_image_for_every_phone_on_index_page() throws Throwable {
        List<String> imageSources = phoneListPage.getPhoneListImageSources();
        imageSources.stream().forEach(imageSource -> {
            assertNotNull(imageSource);
            assertTrue(imageSource.trim().length() > 0);
        });
    }

    @When("^I clear the query on phone list page$")
    public void I_clear_the_query_on_phone_list_page() throws Throwable {
        phoneListPage.clearQuery();
    }
}
