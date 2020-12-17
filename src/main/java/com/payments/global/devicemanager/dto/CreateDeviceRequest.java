package com.payments.global.devicemanager.dto;


import lombok.Data;

@Data
public class CreateDeviceRequest {

    private String serialNumber;
    private String machineCode;
    private String deviceName;
}
