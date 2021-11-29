package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.DeviceInfoMapper;
import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.model.DeviceInitialization;
import com.it.iotplatform.service.DeviceInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceInfoServiceImpl implements DeviceInfoService {
    private final DeviceInfoMapper deviceInfoMapper;

    public DeviceInfoServiceImpl(DeviceInfoMapper deviceInfoMapper) {
        this.deviceInfoMapper = deviceInfoMapper;
    }


    @Override
    public AppResponse<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo) {
        try {
            deviceInfoMapper.addDeviceInfo(deviceInfo);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);        }
        catch (Exception e) {
            e.printStackTrace();
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);        }
    }

    @Override
    public AppResponse<DeviceInfo> deleteDeviceInfo(String deviceNumber) {
        try {
            int response = deviceInfoMapper.deleteDeviceInfoById(deviceNumber);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);        }
    }

    @Override
    public AppResponse<DeviceInfo> updateDeviceInfo(DeviceInfo deviceInfo) {
        try {
            int response = deviceInfoMapper.updateDeviceInfo(deviceInfo);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<DeviceInfo> getDeviceInfoByCondition(DeviceInfo deviceInfo) {
        PageHelper.startPage(deviceInfo.getPage(), deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceInfoMapper.getDeviceInfo(deviceInfo);
        PageInfo<DeviceInfo> pageInfo = new PageInfo<>(deviceInfoList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public List<DeviceInfo> getDeviceInfoByDeviceTypeName(String deviceTypeName) {
        return deviceInfoMapper.getDeviceInfoByDeviceTypeName(deviceTypeName);
    }

    @Override
    public AppResponse<DeviceInfo> getAllDeviceInfo(DeviceInfo deviceInfo) {
        PageHelper.startPage(deviceInfo.getPage(), deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceInfoMapper.getAllDeviceInfo();
        PageInfo<DeviceInfo> pageInfo = new PageInfo<>(deviceInfoList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public List<DeviceInfo> getAllDeviceInfoNoPage() {
        return deviceInfoMapper.getAllDeviceInfo();
    }

    @Override
    public AppResponse<DeviceInfo> updateDeviceStatusWhileEventOccur(DeviceInfo deviceInfo) {
        try {
            deviceInfoMapper.updateDeviceStatusWhileEventOccur(deviceInfo);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e){
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public List<DeviceInfo> getDeviceInfoByDeviceStatus(String deviceStatus) {
        return deviceInfoMapper.getDeviceInfoByDeviceStatus(deviceStatus);
    }

    @Override
    public List<DeviceInfo> getDeviceInfoByDeviceNumber(String deviceNumber) {
        return deviceInfoMapper.getDeviceInfoByDeviceNumber(deviceNumber);
    }

    @Override
    public DeviceInitialization getDataAboutInitialization() {
        return deviceInfoMapper.getDataAboutInitialization();
    }


}

