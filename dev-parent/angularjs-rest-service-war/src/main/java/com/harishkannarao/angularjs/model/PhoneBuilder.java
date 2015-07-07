package com.harishkannarao.angularjs.model;

public class PhoneBuilder {
    private String name;
    private Long age;
    private String description;

    public Phone build() {
        Phone result = new Phone();
        result.setAge(age);
        result.setName(name);
        result.setDescription(description);
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

    public PhoneBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
