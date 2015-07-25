package com.harishkannarao.angularjs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AndroidOsDetails {
    @JsonProperty(value = "os")
    private String os;
    @JsonProperty(value = "ui")
    private String ui;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getUi() {
        return ui;
    }

    public void setUi(String ui) {
        this.ui = ui;
    }
}
