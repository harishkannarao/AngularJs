package com.harishkannarao.angularjs.constants;

public enum Roles {
    ROLE1("role1"), ROLE2("role2"), ROLE3("role3");

    private final String value;
    Roles(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
