package com.payments.global.devicemanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceResponse {
    private String serialNumber;
    private String machineCode;
    private String deviceName;

}
