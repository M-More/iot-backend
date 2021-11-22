package com.it.iotplatform.service;

import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.response.Response;

public interface DeviceInfoService {
    /**
     * 添加设备信息
     * @param deviceInfo 所添加的deviceInfo.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    Response<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 删除设备信息
     * @param deviceNumber 所删除设备信息的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    Response<DeviceInfo> deleteDeviceInfo(String deviceNumber);

    /**
     * 修改设备信息
     * @param deviceInfo 所添加的deviceInfo.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    Response<DeviceInfo> modifyDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 查询设备信息
     * @param deviceNumber 所查询设备信息的id.
     * @return 返回相应的客户端响应JSON格式数据.
     */
    Response<DeviceInfo> getDeviceInfo(String deviceNumber);
}
