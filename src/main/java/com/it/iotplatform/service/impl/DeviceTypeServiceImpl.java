package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.DeviceTypeMapper;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;
import com.it.iotplatform.service.DeviceTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceTypeServiceImpl implements DeviceTypeService {
    private final DeviceTypeMapper deviceTypeMapper;

    public DeviceTypeServiceImpl(DeviceTypeMapper deviceTypeMapper) {
        this.deviceTypeMapper = deviceTypeMapper;
    }

    @Override
    public AppResponse<DeviceType> addDeviceType(DeviceType deviceType) {
        try {
            deviceTypeMapper.addDeviceType(deviceType);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode) {
        try {
            int response = deviceTypeMapper.deleteDeviceTypeById(deviceTypeCode);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<DeviceType> updateDeviceType(DeviceType deviceType) {
        try {
            int response = deviceTypeMapper.updateDeviceType(deviceType);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public DeviceType getDeviceType(String deviceTypeCode) {
        return deviceTypeMapper.getDeviceType(deviceTypeCode);
    }

    @Override
    public List<String> getAllDeviceType() {
        return deviceTypeMapper.getAllDeviceType();
    }
}




