package com.harishkannarao.angularjs.model;

public class UserSessionBuilder {
    private String username;
    private String authToken;

    private UserSessionBuilder() {}

    public static UserSessionBuilder newBuilder() {
        return new UserSessionBuilder();
    }

    public UserSession build() {
        UserSession result = new UserSession();
        result.setUsername(username);
        result.setAuthToken(authToken);
        return result;
    }

    public UserSessionBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserSessionBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }
}
