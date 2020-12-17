package com.payments.global.devicemanager.repository;

import com.payments.global.devicemanager.entity.Device;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    Optional<Device> findDeviceBySerialNumber(String serialNumber);
    Optional<Device> findDeviceBySerialNumberAndMachineCode(String serialNumber, String machineCode);

}
