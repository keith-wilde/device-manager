package com.payments.global.devicemanager.service;

import com.payments.global.devicemanager.entity.Device;

import java.util.Optional;

public interface DeviceService {
    Device findBySerialNumberAndMachineCode(String serialNumber, String machineCode);
    Device createDevice(Device device);
    Device updateDevice(Device device);

}
