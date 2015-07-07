package com.harishkannarao.angularjs.model;

public class PhoneBuilder {
    private String name;
    private Long age;
    private String snippet;

    public Phone build() {
        Phone result = new Phone();
        result.setAge(age);
        result.setName(name);
        result.setSnippet(snippet);
        return result;
    }

    public PhoneBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PhoneBuilder setAge(Long age) {
        this.age = age;
        return this;
    }

    public PhoneBuilder setSnippet(String snippet) {
        this.snippet = snippet;
        return this;
    }
}
