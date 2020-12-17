package com.payments.global.devicemanager.controller;

import com.payments.global.devicemanager.ErrorCode;
import com.payments.global.devicemanager.dto.ErrorMessage;
import com.payments.global.devicemanager.exceptions.InvalidDeviceRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.payments.global.devicemanager.ErrorCode.*;

@ControllerAdvice
public class ErrorController {

    private static final Map<ErrorCode, ErrorMessage> errorMessageMap;

    static {
        errorMessageMap = Map.of(MACHINE_CODE_INVALID, ErrorMessage.builder().resourceKey("machine.code.invalid").errorCode("ER001").message("The machine code is incorrect. Check the Machine code you provided and try again").build()
                , MACHINE_CODE_NOT_FOUND, ErrorMessage.builder().resourceKey("machine.code.not.found").errorCode("ER002").message("The machine code does not match our records.").build()
                , SERIAL_NUMBER_INVALID, ErrorMessage.builder().resourceKey("serial.number.invalid").errorCode("ER003").message("The serial number entered can include a - z, A - Z, 0 - 9 and hyphen. Please correct your" +
                        "entry").build()
                , SERIAL_NUMBER_NOT_FOUND, ErrorMessage.builder().resourceKey("serial.number.not.found").errorCode("ER004").message("The serial number does not match our records").build()
        );
    }

    @ExceptionHandler({InvalidDeviceRequestException.class})
    public ResponseEntity<List<ErrorMessage>> handleInvalidDeviceRequestException(InvalidDeviceRequestException e) {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        if (!CollectionUtils.isEmpty(e.getErrorCodes())) {
            e.getErrorCodes().forEach(errorCode -> {
                errorMessages.add(errorMessageMap.get(errorCode));
            });
        }
        return ResponseEntity.badRequest().body(errorMessages);

    }


}
