package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;

import java.util.List;

public interface DeviceTypeService {

    /**
     * @author : caoqingyu
     * @methodsName : addDeviceType
     * @description : 新增DeviceType信息至数据库
     * @param : DeviceType
     * @return : AppResponse<DeviceType>
     * @throws :
     */
    AppResponse<DeviceType> addDeviceType(DeviceType deviceType);

    /**
     * @author : caoqingyu
     * @methodsName : deleteDeviceTyoe
     * @description : 删除数据库中对应的DeviceType信息
     * @param : DeviceType
     * @return : AppResponse<DeviceType>
     * @throws :
     */
    AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode);

    /**
     * @author : caoqingyu
     * @methodsName : updateDeviceType
     * @description : 更新数据库中的DeviceType信息
     * @param : DeviceType
     * @return : AppResponse<DeviceType>
     * @throws :
     */
    AppResponse<DeviceType> updateDeviceType(DeviceType deviceType);
    /**
     * @author : caoqingyu
     * @methodsName : getAllDeviceTypeName
     * @description : 获取所有的DeviceTypeName
     * @param : null
     * @return : List<DeviceTypeName>
     * @throws :
     */
    List<String> getAllDeviceTypeName();

    /**
     * @author : caoqingyu
     * @methodsName : getAllDeviceType
     * @description : 返回分页形式的所有DeviceType列表数据
     * @param : deviceType
     * @return : AppResponse<DeviceType>
     * @throws :
     */
    AppResponse<DeviceType> getAllDeviceType(DeviceType deviceType);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceTypeBy
     * @description : 根据DeviceTypeName或DeviceTypeCode模糊查询DeviceType信息
     * @param : DeviceType
     * @return : List<DeviceType>
     * @throws :
     */
    List<DeviceType> getDeviceTypeBy(DeviceType deviceType);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceTypePageBy
     * @description : 返回分页形式的根据DeviceTypeName或DeviceTypeCode模糊查询DeviceType信息
     * @param : DeviceType
     * @return : AppResponse<DeviceType>
     * @throws :
     */
    AppResponse<DeviceType> getDeviceTypePageBy(DeviceType deviceType);
}



