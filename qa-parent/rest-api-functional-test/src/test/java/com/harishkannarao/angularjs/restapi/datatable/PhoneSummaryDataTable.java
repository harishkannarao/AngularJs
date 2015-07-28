package com.harishkannarao.angularjs.restapi.datatable;

public class PhoneSummaryDataTable {

    private Long id;
    private String name;
    private Long age;
    private String snippet;

    public PhoneSummaryDataTable(Long id, String name, Long age, String snippet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.snippet = snippet;
    }

    public Long getId() {
        return id;
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
