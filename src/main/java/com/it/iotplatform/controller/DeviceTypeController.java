package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.DeviceType;
import com.it.iotplatform.service.DeviceTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {
    private final DeviceTypeService deviceTypeService;

    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAllDeviceType
      * @description : 返回分页形式的所有DeviceType列表数据
      * @param : deviceType
      * @return : AppResponse<DeviceType>
      * @throws :
    */
    @GetMapping("/getAll")
    private AppResponse<DeviceType> getAllDeviceType(DeviceType deviceType){
        return deviceTypeService.getAllDeviceType(deviceType);
    }

    /**
      * @author : caoqingyu
      * @methodsName : addDeviceType
      * @description : 新增DeviceType信息至数据库
      * @param : DeviceType
      * @return : AppResponse<DeviceType>
      * @throws :
    */
    @PostMapping(value ="/add")
    public AppResponse<DeviceType> addDeviceType(DeviceType deviceType) {
        return deviceTypeService.addDeviceType(deviceType);
    }

    /**
      * @author : caoqingyu
      * @methodsName : deleteDeviceTyoe
      * @description : 删除数据库中对应的DeviceType信息
      * @param : DeviceType
      * @return : AppResponse<DeviceType>
      * @throws :
    */
    @PostMapping(value ="/delete")
    public AppResponse<DeviceType> deleteDeviceType(String deviceTypeCode) {
        return deviceTypeService.deleteDeviceType(deviceTypeCode);
    }

    /**
      * @author : caoqingyu
      * @methodsName : updateDeviceType
      * @description : 更新数据库中的DeviceType信息
      * @param : DeviceType
      * @return : AppResponse<DeviceType>
      * @throws :
    */
    @PostMapping(value ="/update")
    public AppResponse<DeviceType> updateDeviceType(DeviceType deviceType) {
        return deviceTypeService.updateDeviceType(deviceType);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceTypeBy
      * @description : 根据DeviceTypeName或DeviceTypeCode模糊查询DeviceType信息
      * @param : DeviceType
      * @return : List<DeviceType>
      * @throws :
    */
    @GetMapping(value ="/getBy")
    public List<DeviceType> getDeviceTypeBy(DeviceType deviceType){
        return deviceTypeService.getDeviceTypeBy(deviceType);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceType
      * @description : 获取所有的DeviceTypeName
      * @param : null
      * @return : List<DeviceTypeName>
      * @throws :
    */
    @GetMapping(value ="/getAllName")
    public List<String> getDeviceType(){
        return deviceTypeService.getAllDeviceTypeName();
    }

    /**
      * @author : caoqingyu
      * @methodsName : getDeviceTypePageBy
      * @description : 返回分页形式的根据DeviceTypeName或DeviceTypeCode模糊查询DeviceType信息
      * @param : DeviceType
      * @return : AppResponse<DeviceType>
      * @throws :
    */
    @GetMapping(value="/getPageBy")
    public AppResponse<DeviceType> getDeviceTypePageBy(DeviceType deviceType){
        return deviceTypeService.getDeviceTypePageBy(deviceType);
    }
}
