package com.harishkannarao.angularjs.constants;

public enum HttpHeaderErrorCodes {
    UNAUTHORIZED_ERROR("0001", "Unauthorized to see the content"),
    FORBIDDEN_ERROR("0002", "");

    private final String code;
    private final String message;
    HttpHeaderErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
