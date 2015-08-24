package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthAccessElement {
    public static final String PARAM_AUTH_ID = "auth-id";
    public static final String PARAM_AUTH_TOKEN = "auth-token";

    @JsonProperty(value = "authId")
    private String authId;
    @JsonProperty(value = "authToken")
    private String authToken;
    @JsonProperty(value = "authPermissions")
    private List<String> authPermissions;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public List<String> getAuthPermissions() {
        return authPermissions;
    }

    public void setAuthPermissions(List<String> authPermissions) {
        this.authPermissions = authPermissions;
    }
}
