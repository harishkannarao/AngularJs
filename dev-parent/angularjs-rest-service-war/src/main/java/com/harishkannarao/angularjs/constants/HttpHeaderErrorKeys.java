package com.harishkannarao.angularjs.constants;

public enum HttpHeaderErrorKeys {
    ERROR_CODE_KEY("com-harishkannarao-angularjs-error-code"),
    ERROR_MESSAGE_KEY("com-harishkannarao-angularjs-error-message"),
    ERROR_REFERENCE_KEY("com-harishkannarao-angularjs-error-reference"),
    APPLICATION_VALIDATION_ERROR_KEY("application-validation-exception");

    private final String value;
    HttpHeaderErrorKeys(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
