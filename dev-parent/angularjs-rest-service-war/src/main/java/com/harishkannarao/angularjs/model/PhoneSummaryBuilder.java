package com.harishkannarao.angularjs.model;

public class PhoneSummaryBuilder {
    private String name;
    private Long age;
    private String description;
    private String imageUrl;
    private Long id;

    public PhoneSummary build() {
        PhoneSummary result = new PhoneSummary();
        result.setId(id);
        result.setAge(age);
        result.setName(name);
        result.setDescription(description);
        result.setImageUrl(imageUrl);
        return result;
    }

    public PhoneSummaryBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PhoneSummaryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PhoneSummaryBuilder setAge(Long age) {
        this.age = age;
        return this;
    }

    public PhoneSummaryBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PhoneSummaryBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
