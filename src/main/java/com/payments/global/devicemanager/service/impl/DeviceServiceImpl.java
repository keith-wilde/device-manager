package com.payments.global.devicemanager.service.impl;

import com.payments.global.devicemanager.ErrorCode;
import com.payments.global.devicemanager.entity.Device;
import com.payments.global.devicemanager.exceptions.InvalidDeviceRequestException;
import com.payments.global.devicemanager.repository.DeviceRepository;
import com.payments.global.devicemanager.service.DeviceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;


    @Override
    public Device findBySerialNumberAndMachineCode(@NonNull String serialNumber, @NonNull String machineCode) {
        Device device = deviceRepository.findDeviceBySerialNumber(serialNumber).orElseThrow(() -> new InvalidDeviceRequestException(ErrorCode.SERIAL_NUMBER_NOT_FOUND));
        if (!machineCode.equals(device.getMachineCode())) {
            throw new InvalidDeviceRequestException(ErrorCode.MACHINE_CODE_NOT_FOUND);
        }

        return device;
    }

    @Override
    public Device createDevice(@NonNull Device device) {
        device = deviceRepository.save(device);
        return device;
    }

    @Override
    public Device updateDevice(@NonNull Device device) {
        device = findBySerialNumberAndMachineCode(device.getSerialNumber(), device.getMachineCode()); //assuming only Device Name is updatable
        device.setDeviceName(device.getDeviceName());

        return device;
    }

}
