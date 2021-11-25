package com.it.iotplatform.mapper;

import com.it.iotplatform.model.DeviceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceTypeMapper {
    boolean addDeviceType(DeviceType deviceType);
    Integer updateDeviceType(DeviceType deviceType);
    Integer deleteDeviceTypeById(String deviceTypeCode);
    List<DeviceType> getAllDeviceType(DeviceType deviceType);
    List<String> getAllDeviceTypeName();
    List<DeviceType> getDeviceTypeBy(DeviceType deviceType);
}
