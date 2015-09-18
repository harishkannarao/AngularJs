package com.harishkannarao.angularjs.restapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ValidationResponseEntity {
    @JsonProperty(value = "parameterViolations")
    List<ParameterViolation> parameterViolations;

    public List<ParameterViolation> getParameterViolations() {
        return parameterViolations;
    }

    public static class ParameterViolation {
        @JsonProperty(value = "constraintType")
        private String constraintType;
        @JsonProperty(value = "path")
        private String path;
        @JsonProperty(value = "message")
        private String message;
        @JsonProperty(value = "value")
        private String value;

        public String getConstraintType() {
            return constraintType;
        }

        public String getPath() {
            return path;
        }

        public String getMessage() {
            return message;
        }

        public String getValue() {
            return value;
        }
    }
}
