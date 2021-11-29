package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.model.DeviceInitialization;
import com.it.iotplatform.service.DeviceInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {
    private final DeviceInfoService deviceInfoService;

    public DeviceInfoController(DeviceInfoService deviceInfoService) {
        this.deviceInfoService = deviceInfoService;
    }

    /**
      * @author : caoqingyu
      * @methodsName : addDeviceInfo
      * @description : 新增DeviceInfo信息至数据库
      * @param : DeviceInfo
      * @return : AppResponse<DeviceInfo>
      * @throws :
    */
    @PostMapping(value ="/add")
    public AppResponse<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.addDeviceInfo(deviceInfo);
    }

    /**
      * @author : caoqingyu
      * @methodsName : deleteDeviceInfo
      * @description : 删除数据库中对应的DeviceInfo信息
      * @param :
      * @return :
      * @throws :
    */
    @PostMapping(value ="/delete")
    public AppResponse<DeviceInfo> deleteDeviceInfo(String deviceNumber){
        return deviceInfoService.deleteDeviceInfo(deviceNumber);
    }

    /**
      * @author : caoqingyu
      * @methodsName : updateDeviceInfo
      * @description : 更新数据库中的DeviceInfo信息
      * @param : DeviceInfo
      * @return : AppResponse<DeviceInfo>
      * @throws :
    */
    @PostMapping(value ="/update")
    public AppResponse<DeviceInfo> updateDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.updateDeviceInfo(deviceInfo);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceInfoByCondition
      * @description : 根据DeviceTypeName或DeviceBrand或DeviceName返回分页形式的DeviceInfo信息
      * @param : DeviceInfo
      * @return : AppResponse<DeviceInfo>
      * @throws :
    */
    @GetMapping(value ="/getBy")
    public AppResponse<DeviceInfo> getDeviceInfoByCondition(DeviceInfo deviceInfo){
        return deviceInfoService.getDeviceInfoByCondition(deviceInfo);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAllDeviceInfo
      * @description : 返回分页形式的所有DeviceInfo列表数据
      * @param : DeviceInfo
      * @return : AppResponse<DeviceInfo>
      * @throws :
    */
    @GetMapping(value ="/getAll")
    public AppResponse<DeviceInfo> getAllDeviceInfo(DeviceInfo deviceInfo){
        return deviceInfoService.getAllDeviceInfo(deviceInfo);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceInfoByName
      * @description : 根据DeviceTypeName获取对应的DeviceInfo信息
      * @param : DeviceTypeName
      * @return : List<DeviceInfo>
      * @throws :
    */
    @GetMapping(value ="/getByName")
    public List<DeviceInfo> getDeviceInfoByName(String deviceTypeName){
        return deviceInfoService.getDeviceInfoByDeviceTypeName(deviceTypeName);
    }

    /**
      * @author : caoqingyu
      * @methodsName : noPageGetAll
      * @description : 返回无分页形式的所有DeviceInfo列表数据
      * @param : null
      * @return : List<DeviceInfo>
      * @throws :
    */
    @GetMapping(value = "/nopageget")
    public List<DeviceInfo> noPageGetAll(){
        return deviceInfoService.getAllDeviceInfoNoPage();
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceInfoByDeviceStatus
      * @description : 根据DeviceStatus返回对应的DeviceInfo信息
      * @param : DeviceStatus
      * @return : List<DeviceInfo>
      * @throws :
    */
    @GetMapping(value = "/getByStatus")
    public List<DeviceInfo> getDeviceInfoByDeviceStatus(String deviceStatus){
        return deviceInfoService.getDeviceInfoByDeviceStatus(deviceStatus);
    }

    /**
      * @author : caoqingyu
      * @methodsName : updateDeviceStatusWhileEventOccur
      * @description : 当事件发生时更新DeviceInfo对应设备的DeviceStatus
      * @param : DeviceInfo
      * @return : AppResponse<DeviceInfo>
      * @throws :
    */
    @PostMapping(value ="/updatestatus")
    public AppResponse<DeviceInfo> updateDeviceStatusWhileEventOccur(DeviceInfo deviceInfo){
        return deviceInfoService.updateDeviceStatusWhileEventOccur(deviceInfo);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceInfoByDeviceNumber
      * @description : 根据DeviceNumber返回对应的DeviceInfo信息
      * @param : DeviceNumber
      * @return : List<DeviceInfo>
      * @throws :
    */
    @GetMapping(value = "/getByNumber")
    public List<DeviceInfo> getDeviceInfoByDeviceNumber(String deviceNumber){
        return deviceInfoService.getDeviceInfoByDeviceNumber(deviceNumber);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDataAboutInitialization
      * @description : 大屏初始化时返回所需信息DeviceInitialization
      * @param : null
      * @return : DeviceInitialization
      * @throws :
    */
    @GetMapping(value = "/deviceInitialize")
    public DeviceInitialization getDataAboutInitialization(){
        return deviceInfoService.getDataAboutInitialization();
    }
}
