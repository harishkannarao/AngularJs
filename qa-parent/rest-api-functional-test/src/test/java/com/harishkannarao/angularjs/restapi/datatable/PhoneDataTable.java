package com.harishkannarao.angularjs.restapi.datatable;

public class PhoneDataTable {

    private String name;
    private Long age;
    private String snippet;

    public PhoneDataTable(String name, Long age, String snippet) {
        this.name = name;
        this.age = age;
        this.snippet = snippet;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getSnippet() {
        return snippet;
    }
}
