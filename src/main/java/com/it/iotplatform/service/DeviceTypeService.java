package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    /**
     * 添加设备类型
     * @param deviceType 所添加的deviceType.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceType> addDeviceType(DeviceType deviceType);

    /**
     * 删除设备类型
     * @param deviceTypeCode 所删除设备的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode);

    /**
     * 修改设备类型
     * @param deviceType 所添加的deviceType.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceType> updateDeviceType(DeviceType deviceType);

    /**
     * 查询设备类型
     * @param deviceTypeCode 所查询设备的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    DeviceType getDeviceType(String deviceTypeCode);

    List<String> getAllDeviceType();

    List<DeviceType> getDeviceTypeByDeviceTypeName(String deviceTypeName);
}



