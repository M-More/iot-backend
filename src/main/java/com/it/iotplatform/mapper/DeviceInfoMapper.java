package com.it.iotplatform.mapper;

import com.it.iotplatform.model.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceInfoMapper {
    boolean addDeviceInfo(DeviceInfo deviceInfo);
    Integer updateDeviceInfo(DeviceInfo deviceInfo);
    Integer deleteDeviceInfoById(String deviceNumber);
    DeviceInfo getDeviceInfo(String deviceNumber);
}
