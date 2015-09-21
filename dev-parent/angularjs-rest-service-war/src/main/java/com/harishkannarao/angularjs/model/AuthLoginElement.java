package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.harishkannarao.angularjs.validation.constraint.NotNullAndNonEmptyString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthLoginElement {

    @NotNullAndNonEmptyString
    @JsonProperty(value = "username")
    private String username;
    @NotNullAndNonEmptyString
    @JsonProperty(value = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
