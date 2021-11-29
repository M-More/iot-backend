package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.model.DeviceInitialization;

import java.util.List;

public interface DeviceInfoService {

    /**
     * @author : caoqingyu
     * @methodsName : addDeviceInfo
     * @description : 新增DeviceInfo信息至数据库
     * @param : DeviceInfo
     * @return : AppResponse<DeviceInfo>
     * @throws :
     */
    AppResponse<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo);

    /**
     * @author : caoqingyu
     * @methodsName : deleteDeviceInfo
     * @description : 删除数据库中对应的DeviceInfo信息
     * @param :
     * @return :
     * @throws :
     */
    AppResponse<DeviceInfo> deleteDeviceInfo(String deviceNumber);

    /**
     * @author : caoqingyu
     * @methodsName : updateDeviceInfo
     * @description : 更新数据库中的DeviceInfo信息
     * @param : DeviceInfo
     * @return : AppResponse<DeviceInfo>
     * @throws :
     */
    AppResponse<DeviceInfo> updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceInfoByCondition
     * @description : 根据DeviceTypeName或DeviceBrand或DeviceName返回分页形式的DeviceInfo信息
     * @param : DeviceInfo
     * @return : AppResponse<DeviceInfo>
     * @throws :
     */
    AppResponse<DeviceInfo> getDeviceInfoByCondition(DeviceInfo deviceInfo);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceInfoByDeviceTypeName
     * @description : 根据DeviceTypeName获取对应的DeviceInfo信息
     * @param : DeviceTypeName
     * @return : List<DeviceInfo>
     * @throws :
     */
    List<DeviceInfo> getDeviceInfoByDeviceTypeName(String deviceTypeName);

    /**
     * @author : caoqingyu
     * @methodsName : getAllDeviceInfo
     * @description : 返回分页形式的所有DeviceInfo列表数据
     * @param : DeviceInfo
     * @return : AppResponse<DeviceInfo>
     * @throws :
     */
    AppResponse<DeviceInfo> getAllDeviceInfo(DeviceInfo deviceInfo);

    /**
     * @author : caoqingyu
     * @methodsName : getAllDeviceInfoNoPage
     * @description : 返回无分页形式的所有DeviceInfo列表数据
     * @param : null
     * @return : List<DeviceInfo>
     * @throws :
     */
    List<DeviceInfo> getAllDeviceInfoNoPage();

    /**
     * @author : caoqingyu
     * @methodsName : updateDeviceStatusWhileEventOccur
     * @description : 当事件发生时更新DeviceInfo对应设备的DeviceStatus
     * @param : DeviceInfo
     * @return : AppResponse<DeviceInfo>
     * @throws :
     */
    AppResponse<DeviceInfo> updateDeviceStatusWhileEventOccur(DeviceInfo deviceInfo);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceInfoByDeviceStatus
     * @description : 根据DeviceStatus返回对应的DeviceInfo信息
     * @param : DeviceStatus
     * @return : List<DeviceInfo>
     * @throws :
     */
    List<DeviceInfo> getDeviceInfoByDeviceStatus(String deviceStatus);

    /**
     * @author : caoqingyu
     * @methodsName : getDeviceInfoByDeviceNumber
     * @description : 根据DeviceNumber返回对应的DeviceInfo信息
     * @param : DeviceNumber
     * @return : List<DeviceInfo>
     * @throws :
     */
    List<DeviceInfo> getDeviceInfoByDeviceNumber(String deviceNumber);

    /**
     * @author : caoqingyu
     * @methodsName : getDataAboutInitialization
     * @description : 大屏初始化时返回所需信息DeviceInitialization
     * @param : null
     * @return : DeviceInitialization
     * @throws :
     */
    DeviceInitialization getDataAboutInitialization();
}
