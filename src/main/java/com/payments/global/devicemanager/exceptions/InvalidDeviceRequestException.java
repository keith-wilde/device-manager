package com.payments.global.devicemanager.exceptions;

import com.payments.global.devicemanager.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDeviceRequestException extends RuntimeException{
    private List<ErrorCode> errorCodes;

    public InvalidDeviceRequestException(ErrorCode errorCode){
        super();
        this.errorCodes = Collections.singletonList(errorCode);
    }

    public InvalidDeviceRequestException(List<ErrorCode> errorCodes){
        super();
        this.errorCodes = errorCodes;
    }

    public List<ErrorCode> getErrorCodes() {
        return errorCodes;
    }
}
