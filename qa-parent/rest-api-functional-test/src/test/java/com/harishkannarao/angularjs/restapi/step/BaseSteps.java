package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.client.SingletonRestClient;
import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;
import com.harishkannarao.angularjs.restapi.entity.ValidationResponseEntity;
import com.harishkannarao.angularjs.restapi.util.PropertiesReference;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class BaseSteps {
    protected static final String APP_SERVER_URL = PropertiesReference.MAVEN_PROPERTIES.getProperty("appServerSslUrl");
    protected static final String APPLICATION_CONTEXT = "restapi";
    protected static final String TEST_SUPPORT_CONTEXT = "angularjs-test-support-war";
    protected static final String PATH_SEPARATOR = "/";
    protected static final String APPLICATION_URL = APP_SERVER_URL + PATH_SEPARATOR + APPLICATION_CONTEXT;
    protected static final String TEST_SUPPORT_URL = APP_SERVER_URL + PATH_SEPARATOR + TEST_SUPPORT_CONTEXT;

    protected static final WebTarget serverTarget = SingletonRestClient.getInstance().target(APP_SERVER_URL);
    protected static final WebTarget restApiBaseTarget = SingletonRestClient.getInstance().target(APPLICATION_URL + "/service");
    protected static final WebTarget testSupportRestApiBaseTarget = SingletonRestClient.getInstance().target(TEST_SUPPORT_URL + "/rest");

    protected static final String VALIDATION_HEADER_KEY = "validation-exception";
    protected static final String APPLICATION_VALIDATION_HEADER_KEY = "application-validation-exception";

    protected static final String AUTH_ID_HEADER_KEY = "auth-id";
    protected static final String AUTH_TOKEN_HEADER_KEY = "auth-token";

    protected WebTarget target;
    protected Response response;

    protected ValidationResponseEntity getValidationResponseEntity() {
        return response.readEntity(new GenericType<ValidationResponseEntity>() {});
    }
}
