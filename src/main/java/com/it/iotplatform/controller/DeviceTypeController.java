package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;
import com.it.iotplatform.service.DeviceTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {
    private final DeviceTypeService deviceTypeService;

    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    @GetMapping("/getAll")
    private List<String> getAllDeviceType(){
        return deviceTypeService.getAllDeviceType();
    }

    @PostMapping(value ="/add")
    public AppResponse<DeviceType> addDeviceType(DeviceType deviceType) {
        return deviceTypeService.addDeviceType(deviceType);
    }

    @PostMapping(value ="/delete")
    public AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode) {
        return deviceTypeService.deleteDeviceType(deviceTypeCode);
    }

    @PostMapping(value ="/update")
    public AppResponse<DeviceType> updateDeviceType(DeviceType deviceType) {
        return deviceTypeService.updateDeviceType(deviceType);
    }

    @GetMapping(value ="/getBy")
    public DeviceType getDeviceType(String deviceTypeCode){
        return deviceTypeService.getDeviceType(deviceTypeCode);
    }
}
