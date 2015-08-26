package com.harishkannarao.angularjs.model;

import com.harishkannarao.angularjs.constants.Roles;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Roles> authRoles;

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

    public List<Roles> getAuthRoles() {
        return authRoles;
    }

    public void setAuthRoles(List<Roles> authRoles) {
        this.authRoles = authRoles;
    }
}
