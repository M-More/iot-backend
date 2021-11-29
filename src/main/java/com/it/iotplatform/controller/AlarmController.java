package com.it.iotplatform.controller;


import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.Supplier;
import com.it.iotplatform.service.AlarmService;
import com.it.iotplatform.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/alarm")
public class AlarmController {
    @Resource
    private AlarmService alarmService;

    public AlarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAllAlarm
      * @description : 返回分页形式的所有Alarm列表数据
      * @param : Alarm
      * @return : AppResposne<Alarm>
      * @throws :
    */
    @GetMapping("/getAll")
    private AppResponse<Alarm> getAllAlarm(Alarm alarm){
        return alarmService.getAllAlarm(alarm);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAlarmByCondition
      * @description : 根据AlarmLevel&AlarmName&AlarmCode返回对应分页形式的Alarm列表数据
      * @param : Alarm
      * @return : AppResponse<Alarm>
      * @throws :
    */
    @GetMapping("/getByCondition")
    private AppResponse<Alarm> getAlarmByCondition(Alarm alarm){
        return alarmService.getAlarmByCondition(alarm);
    }

    /**
      * @author : caoqingyu
      * @methodsName : addAlarm
      * @description : 新增Alarm信息至数据库
      * @param : Alarm
      * @return : AppResponse<Alarm>
      * @throws :
    */
    @PostMapping("/add")
    private AppResponse<Alarm> addAlarm(Alarm alarm){
        return alarmService.addAlarm(alarm);
    }

    /**
      * @author : caoqingyu
      * @methodsName : updateAlarm
      * @description : 更新数据库中的Alarm信息
      * @param : Alarm
      * @return : AppResponse<Alarm>
      * @throws :
    */
    @PostMapping("/update")
    private AppResponse<Alarm> updateAlarm(Alarm alarm){
        return alarmService.updateAlarm(alarm);
    }

    /**
      * @author : caoqingyu
      * @methodsName : deleteAlarm
      * @description : 删除数据库中对应的Alarm信息
      * @param : Alarm
      * @return : AppResponse<Alarm>
      * @throws :
    */
    @PostMapping("/delete")
    private AppResponse<Alarm> deleteAlarm(Alarm alarm){
        return alarmService.deleteAlarm(alarm);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAlarmNameByDeviceTypeName
      * @description : 获得此设备类型下所有的告警名称
      * @param : Alarm
      * @return : List<AlarmName>
      * @throws :
    */
    @GetMapping("/getBy")
    private List<String> getAlarmNameByDeviceTypeName(Alarm alarm) {
        return alarmService.getAlarmByDevice(alarm);
    }
}
