package com.payments.global.devicemanager.controller;

import com.payments.global.devicemanager.ErrorCode;
import com.payments.global.devicemanager.dto.CreateDeviceRequest;
import com.payments.global.devicemanager.dto.DeviceResponse;
import com.payments.global.devicemanager.entity.Device;
import com.payments.global.devicemanager.exceptions.InvalidDeviceRequestException;
import com.payments.global.devicemanager.service.DeviceService;
import com.payments.global.devicemanager.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/find")
    public ResponseEntity<DeviceResponse> findDevice(@RequestParam String serialNumber, @RequestParam String machineCode) {
        validateSerialNo(serialNumber);
        Device device = deviceService.findBySerialNumberAndMachineCode(serialNumber, machineCode);
        return ResponseEntity.ok(DeviceResponse.builder()
                .serialNumber(device.getSerialNumber()).deviceName(device.getDeviceName())
                .machineCode(device.getMachineCode()).build());
    }

    @PutMapping("/update")
    public ResponseEntity<DeviceResponse> updateDevice(@RequestBody CreateDeviceRequest request) {
        validateSerialNo(request.getSerialNumber());

        Device device = deviceService.updateDevice(Device.builder()
                .machineCode(request.getMachineCode())
                .deviceName(request.getDeviceName())
                .serialNumber(request.getSerialNumber())
                .build());

        return ResponseEntity.ok(DeviceResponse.builder()
                .serialNumber(device.getSerialNumber()).deviceName(device.getDeviceName())
                .machineCode(device.getMachineCode()).build());
    }

    @PostMapping("/create")
    public ResponseEntity<DeviceResponse> createDevice(@RequestBody CreateDeviceRequest request) {
        validateSerialNo(request.getSerialNumber());
        Device device = deviceService.createDevice(Device.builder()
                .machineCode(request.getMachineCode())
                .deviceName(request.getDeviceName())
                .serialNumber(request.getSerialNumber())
                .build());

        return ResponseEntity.ok(DeviceResponse.builder()
                .serialNumber(device.getSerialNumber()).deviceName(device.getDeviceName())
                .machineCode(device.getMachineCode()).build());
    }

    private void validateSerialNo(String serialNumber) {
        if (!isSerialNumberValid(serialNumber)) {
            throw new InvalidDeviceRequestException(ErrorCode.SERIAL_NUMBER_INVALID);
        }
    }

    private boolean isSerialNumberValid(String serialNumber){
        if(StringUtils.hasLength(serialNumber)){
            return ValidationUtil.isSerialNumberValid(serialNumber);
        }
        return false;
    }


}
