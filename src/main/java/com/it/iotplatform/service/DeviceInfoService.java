package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.model.DeviceInitialization;

import java.util.List;

public interface DeviceInfoService {
    /**
     * 添加设备信息
     * @param deviceInfo 所添加的deviceInfo.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 删除设备信息
     * @param deviceNumber 所删除设备信息的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceInfo> deleteDeviceInfo(String deviceNumber);

    /**
     * 修改设备信息
     * @param deviceInfo 所添加的deviceInfo.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    AppResponse<DeviceInfo> updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 查询设备信息
     * @param deviceNumber 所查询设备信息的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    List<DeviceInfo> getDeviceInfo(DeviceInfo deviceInfo);

    List<DeviceInfo> getDeviceInfoByDeviceTypeName(String deviceTypeName);

    AppResponse<DeviceInfo> getAllDeviceInfo(DeviceInfo deviceInfo);

    List<DeviceInfo> getAllDeviceInfoNoPage();

    AppResponse<DeviceInfo> updateDeviceStatusWhileEventOccur(DeviceInfo deviceInfo);

    List<DeviceInfo> getDeviceInfoByDeviceStatus(String deviceStatus);

    List<DeviceInfo> getDeviceInfoByDeviceNumber(String deviceNumber);

    DeviceInitialization getDataAboutInitialization();
}
