package com.it.iotplatform.mapper;

import com.it.iotplatform.model.DeviceType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceTypeMapper {
    boolean addDeviceType(DeviceType deviceType);
    Integer updateDeviceType(DeviceType deviceType);
    Integer deleteDeviceTypeById(String deviceTypeCode);
    DeviceType getDeviceType(String deviceTypeCode);
}
