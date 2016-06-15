package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.IndexPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class IndexPageSteps {

    public static final String SOME_JUNK_URL = "#/someJunkUrl";

    @Inject
    private IndexPage indexPage;

    @Given("^I go to index page$")
    public void I_go_to_index_page() throws Throwable {
        indexPage.navigate();
    }

    @Given("^I go to a non-existing page$")
    public void I_go_to_a_non_existing_page() throws Throwable {
        indexPage.navigateToPath(SOME_JUNK_URL);
    }

    @And("^I click on Login link$")
    public void iClickOnLoginLink() throws Throwable {
        indexPage.clickLogin();
    }

    @Then("^I should see \"([^\"]*)\" link$")
    public void iShouldSeeLink(String linkText) throws Throwable {
        assertTrue(indexPage.isLinkDisplayed(linkText), linkText + " is not displayed on the page");
    }

    @And("^I should not see \"([^\"]*)\" link$")
    public void iShouldNotSeeLink(String linkText) throws Throwable {
        assertFalse(indexPage.isLinkDisplayed(linkText), linkText + " is displayed on the page");
    }

    @And("^I logout if already logged in$")
    public void iLogoutIfAlreadyLoggedIn() throws Throwable {
        if(indexPage.isLoggedIn()) {
            indexPage.clickLogout();
        }
    }

    @And("^I click on Logout link$")
    public void iClickOnLogoutLink() throws Throwable {
        indexPage.clickLogout();
    }
}
