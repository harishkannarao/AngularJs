package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;
import com.harishkannarao.angularjs.restapi.holder.EntityHolder;
import cucumber.api.java.en.And;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.testng.Assert.*;

@ApplicationScoped
public class AuthAccessEndpointSteps extends BaseSteps {
    private static final WebTarget authAccessEndpoint = restApiBaseTarget.path("/auth/authAccess");

    @Inject
    private EntityHolder entityHolder;

    private String authIdHeader;
    private String authTokenHeader;

    private AuthAccessEntity getAuthAccessEntity() {
        return response.readEntity(new GenericType<AuthAccessEntity>() {});
    }

    @And("^I set the url to auth access endpoint$")
    public void setUrl() throws Throwable {
        this.target = authAccessEndpoint;
    }

    @And("^I set the authId header to auth access endpoint$")
    public void setAuthIdHeader() throws Throwable {
        this.authIdHeader = entityHolder.getAuthAccessEntity().getAuthId();
    }

    @And("^I set the authToken header to auth access endpoint$")
    public void setAuthTokenHeader() throws Throwable {
        this.authTokenHeader = entityHolder.getAuthAccessEntity().getAuthToken();
    }

    @And("^I make a GET request to auth access endpoint$")
    public void makeGetRequest() throws Throwable {
        this.response = this.target.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, authIdHeader)
                .header(AUTH_TOKEN_HEADER_KEY, authTokenHeader)
                .get();
        this.response.bufferEntity();
    }

    @And("^I should get http response status as (\\d+) from auth access endpoint$")
    public void assertHttpStatus(int httpStatus) throws Throwable {
        assertEquals(response.getStatus(), httpStatus);
    }

    @And("^I should see authId as \"(.*)\" from auth access endpoint$")
    public void assertAuthId(String authId) throws Throwable {
        assertEquals(getAuthAccessEntity().getAuthId(), authId);
    }

    @And("^I should see non empty authToken from auth access endpoint$")
    public void assertNonEmptyAuthToken() throws Throwable {
        AuthAccessEntity authAccessEntity = getAuthAccessEntity();
        assertNotNull(authAccessEntity.getAuthToken());
        assertFalse(authAccessEntity.getAuthToken().isEmpty());
    }

    @And("^I should see authPermissions as below from auth access endpoint$")
    public void assertAuthPermissions(List<String> authPermissions) throws Throwable {
        AuthAccessEntity authAccessEntity = getAuthAccessEntity();
        assertEquals(authAccessEntity.getAuthPermissions().size(), authPermissions.size());
        assertEquals(authAccessEntity.getAuthPermissions(), authPermissions);
    }
}
