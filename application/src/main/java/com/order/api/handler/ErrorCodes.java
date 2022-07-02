package com.order.api.handler;

public enum ErrorCodes {

    ENTITY_NOT_FOUND("00001", "ENTITY_NOT_FOUND"),
    CONSTRAINT_VIOLATION("00002", "CONSTRAINT_VIOLATION"),
    BUSINESS_VIOLATION("00003", "BUSINESS_VIOLATION"),
    INTEGRATION_EXCEPTION("00004", "INTEGRATION_EXCEPTION");

    private final String message;
    private final String code;

    ErrorCodes(String code, String message) {
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
