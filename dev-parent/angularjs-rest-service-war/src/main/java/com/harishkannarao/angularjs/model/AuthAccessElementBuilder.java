package com.harishkannarao.angularjs.model;

import java.util.ArrayList;
import java.util.List;

public class AuthAccessElementBuilder {

    private String authId;
    private String authToken;
    private List<String> authPermissions;

    private AuthAccessElementBuilder() {}

    public static AuthAccessElementBuilder newBuilder() {
        return new AuthAccessElementBuilder();
    }

    public AuthAccessElement build() {
        AuthAccessElement result = new AuthAccessElement();
        result.setAuthId(authId);
        result.setAuthToken(authToken);
        result.setAuthPermissions(authPermissions);
        return result;
    }

    public AuthAccessElementBuilder setAuthId(String authId) {
        this.authId = authId;
        return this;
    }

    public AuthAccessElementBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public AuthAccessElementBuilder setAuthPermissions(List<String> authPermissions) {
        this.authPermissions = authPermissions;
        return this;
    }

    public AuthAccessElementBuilder addAuthPermission(String authPermission) {
        if(this.authPermissions == null) {
            this.authPermissions = new ArrayList<>();
        }
        this.authPermissions.add(authPermission);
        return this;
    }
}
