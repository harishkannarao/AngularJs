package com.harishkannarao.angularjs.model;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    private String username;
    private String password;
    private String authToken;
    private List<String> authRoles;

    private UserBuilder() {}

    public static UserBuilder newBuilder() {
        return new UserBuilder();
    }

    public User build() {
        User result = new User();
        result.setUsername(username);
        result.setPassword(password);
        result.setAuthToken(authToken);
        result.setAuthRoles(authRoles);
        return result;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public UserBuilder setAuthRoles(List<String> authRoles) {
        this.authRoles = authRoles;
        return this;
    }

    public UserBuilder addAuthRole(String authRole) {
        if(this.authRoles == null) {
            this.authRoles = new ArrayList<>();
        }
        this.authRoles.add(authRole);
        return this;
    }
}
