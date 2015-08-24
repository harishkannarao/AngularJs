package com.harishkannarao.angularjs.model;

public class AuthLoginElementBuilder {
    private String username;
    private String password;

    private AuthLoginElementBuilder() {}

    public static AuthLoginElementBuilder newBuilder() {
        return new AuthLoginElementBuilder();
    }

    public AuthLoginElement build() {
        AuthLoginElement result = new AuthLoginElement();
        result.setUsername(username);
        result.setPassword(password);
        return result;
    }

    public AuthLoginElementBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public AuthLoginElementBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
}
