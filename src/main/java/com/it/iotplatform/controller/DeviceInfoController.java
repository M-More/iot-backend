package com.it.iotplatform.controller;

import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.response.Response;
import com.it.iotplatform.service.DeviceInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {
    private final DeviceInfoService deviceInfoService;

    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @PostMapping(value ="/addDeviceInfo")
    public Response<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.addDeviceInfo(deviceInfo);
    }

    @PostMapping(value ="/deleteDeviceInfo")
    public Response<DeviceInfo> deleteDeviceInfo(String deviceNumber){
        return deviceInfoService.deleteDeviceInfo(deviceNumber);
    }

    @PostMapping(value ="/modifyDeviceInfo")
    public Response<DeviceInfo> modifyDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.modifyDeviceInfo(deviceInfo);
    }

    @GetMapping(value ="/getDeviceInfo")
    public Response<DeviceInfo> getDeviceInfo(String deviceNumber){
        return deviceInfoService.getDeviceInfo(deviceNumber);
    }
}
