package com.payments.global.devicemanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

    private String resourceKey;
    private String errorCode;
    private String message;

}
