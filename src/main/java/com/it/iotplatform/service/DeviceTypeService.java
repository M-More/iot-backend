package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    AppResponse<DeviceType> addDeviceType(DeviceType deviceType);

    AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode);

    AppResponse<DeviceType> updateDeviceType(DeviceType deviceType);

    List<String> getAllDeviceTypeName();

    AppResponse<DeviceType> getAllDeviceType(DeviceType deviceType);

    List<DeviceType> getDeviceTypeBy(DeviceType deviceType);

    AppResponse<DeviceType> getAllDeviceTypePageBy(DeviceType deviceType);
}



