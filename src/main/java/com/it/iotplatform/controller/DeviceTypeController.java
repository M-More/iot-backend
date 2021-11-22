package com.it.iotplatform.controller;

import com.it.iotplatform.model.DeviceType;
import com.it.iotplatform.response.Response;
import com.it.iotplatform.service.DeviceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {
    private final DeviceTypeService deviceTypeService;

    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    @PostMapping(value ="/addDeviceType")
    public Response<DeviceType> addDeviceType(DeviceType deviceType){
        return deviceTypeService.addDeviceType(deviceType);
    }

    @PostMapping(value ="/deleteDeviceType")
    public Response<DeviceType> deleteDeviceType(String deviceTypeCode){
        return deviceTypeService.deleteDeviceType(deviceTypeCode);
    }

    @PostMapping(value ="/modifyDeviceType")
    public Response<DeviceType> modifyDeviceType(DeviceType deviceType){
        return deviceTypeService.modifyDeviceType(deviceType);
    }

    @GetMapping(value ="/getDeviceType")
    public Response<DeviceType> getDeviceType(String deviceTypeCode){
        return deviceTypeService.getDeviceType(deviceTypeCode);
    }
}
