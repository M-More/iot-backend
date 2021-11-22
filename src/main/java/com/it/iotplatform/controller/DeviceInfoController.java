package com.it.iotplatform.controller;

import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.response.Response;
import com.it.iotplatform.service.DeviceInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DeviceInfoController {
    private final DeviceInfoService deviceInfoService;

    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    @PostMapping(value ="/addDeviceInfo")
    public Response<DeviceInfo> addDeviceInfo(DeviceInfo user){
        return deviceInfoService.addDeviceInfo(user);
    }

    @PostMapping(value ="/deleteDeviceInfo")
    public Response<DeviceInfo> deleteDeviceInfo(String id){
        return deviceInfoService.deleteDeviceInfo(id);
    }

    @PostMapping(value ="/modifyDeviceInfo")
    public Response<DeviceInfo> modifyDeviceInfo(DeviceInfo user){
        return deviceInfoService.modifyDeviceInfo(user);
    }

    @GetMapping(value ="/getDeviceInfo")
    public Response<DeviceInfo> getDeviceInfo(String id){
        return deviceInfoService.getDeviceInfo(id);
    }
}
