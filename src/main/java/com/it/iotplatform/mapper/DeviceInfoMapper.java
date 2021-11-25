package com.it.iotplatform.mapper;

import com.it.iotplatform.model.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceInfoMapper {
    boolean addDeviceInfo(DeviceInfo deviceInfo);
    Integer updateDeviceInfo(DeviceInfo deviceInfo);
    Integer deleteDeviceInfoById(String deviceNumber);
    List<DeviceInfo> getDeviceInfo(DeviceInfo deviceInfo);
    List<DeviceInfo> getAllDeviceInfo();
    List<DeviceInfo> getDeviceInfoByDeviceTypeName(String deviceTypeName);
    Integer updateDeviceStatusWhileEventOccur(DeviceInfo deviceInfo);
    List<DeviceInfo> getDeviceInfoByDeviceStatus(String deviceStatus);
    List<DeviceInfo> getDeviceInfoByDeviceNumber(String deviceNumber);
}
