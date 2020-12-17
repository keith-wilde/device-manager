package com.payments.global.devicemanager;

public enum ErrorCode {

    MACHINE_CODE_INVALID("ER001"),
    MACHINE_CODE_NOT_FOUND("ER002"),
    SERIAL_NUMBER_INVALID("ER003"),
    SERIAL_NUMBER_NOT_FOUND("ER004(");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
