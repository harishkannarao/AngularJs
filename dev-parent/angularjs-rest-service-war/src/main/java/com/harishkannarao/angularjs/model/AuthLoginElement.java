package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthLoginElement {

    @NotNull(message = "key=authLoginElement.username;message={javax.validation.constraints.NotNull.message}")
    @Pattern(regexp="^.+$", message = "key=authLoginElement.username;message={javax.validation.constraints.Pattern.message}")
    @JsonProperty(value = "username")
    private String username;
    @NotNull(message = "key=authLoginElement.password;message={javax.validation.constraints.NotNull.message}")
    @Pattern(regexp="^.+$", message = "key=authLoginElement.password;message={javax.validation.constraints.Pattern.message}")
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
