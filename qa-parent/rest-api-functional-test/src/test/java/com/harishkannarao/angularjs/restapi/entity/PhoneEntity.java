package com.harishkannarao.angularjs.restapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneEntity {

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "age")
    private Long age;
    @JsonProperty(value = "snippet")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
