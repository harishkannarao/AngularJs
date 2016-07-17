package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;
import com.harishkannarao.angularjs.restapi.entity.AuthLoginEntity;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class AuthSuperSecretEndpointSteps extends BaseSteps {

    private static final WebTarget authSuperSecretEndpoint = restApiBaseTarget.path("/auth/superSecret");

    private AuthAccessEntity authAccessEntity;

    @Given("^I get auth token for user ([^\"]*) and password ([^\"]*) for super secret endpoint$")
    public void iGetAuthTokenForUserUsernameAndPasswordPasswordForSuperSecretEndpoint(String username, String password) throws Throwable {
        AuthLoginEntity authLoginEntity = new AuthLoginEntity();
        authLoginEntity.setUsername(username);
        authLoginEntity.setPassword(password);
        Response loginResponse = AuthLoginEndpointSteps.authLoginEndpoint.request(MediaType.APPLICATION_JSON).post(Entity.entity(authLoginEntity, MediaType.APPLICATION_JSON));
        loginResponse.bufferEntity();
        authAccessEntity = loginResponse.readEntity(new GenericType<AuthAccessEntity>() {
        });
    }

    @And("^I make a GET request with logged in user to super secret endpoint$")
    public void iMakeAGETRequestWithLoggedInUserToSuperSecretEndpoint() throws Throwable {
        this.response = authSuperSecretEndpoint.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, authAccessEntity.getAuthId())
                .header(AUTH_TOKEN_HEADER_KEY, authAccessEntity.getAuthToken())
                .get();
        this.response.bufferEntity();
    }

    @Then("^I should get http response status as (\\d+) from super secret endpoint$")
    public void iShouldGetHttpResponseStatusAsFromSuperSecretEndpoint(int expectedStatus) throws Throwable {
        assertEquals(this.response.getStatus(), expectedStatus);
    }

    @Then("^I should get http forbidden response header as true from super secret endpoint$")
    public void iShouldGetHttpForbiddenResponseHeaderAsTrueFromSuperSecretEndpoint() throws Throwable {
        assertTrue(Boolean.valueOf(this.response.getHeaderString("com-harishkannarao-angularjs-forbidden")));
    }

    @Given("^I make a GET request without user headers to super secret endpoint$")
    public void iMakeAGETRequestWithoutUserHeadersToSuperSecretEndpoint() throws Throwable {
        this.response = authSuperSecretEndpoint.request(MediaType.APPLICATION_JSON)
                .get();
        this.response.bufferEntity();
    }
}
