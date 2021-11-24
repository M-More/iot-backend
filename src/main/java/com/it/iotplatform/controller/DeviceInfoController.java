package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.service.DeviceInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {
    private final DeviceInfoService deviceInfoService;

    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @PostMapping(value ="/add")
    public AppResponse<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.addDeviceInfo(deviceInfo);
    }

    @PostMapping(value ="/delete")
    public AppResponse<DeviceInfo> deleteDeviceInfo(String deviceNumber){
        return deviceInfoService.deleteDeviceInfo(deviceNumber);
    }

    @PostMapping(value ="/update")
    public AppResponse<DeviceInfo> updateDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.updateDeviceInfo(deviceInfo);
    }

    @GetMapping(value ="/getBy")
    public List<DeviceInfo> getDeviceInfo(String deviceNumber){
        return deviceInfoService.getDeviceInfo(deviceNumber);
    }

    @GetMapping(value ="/getAll")
    public AppResponse<DeviceInfo> getAllDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.getAllDeviceInfo(deviceInfo);
    }
}
