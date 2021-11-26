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

    @GetMapping("/getAll")
    private AppResponse<Alarm> getAllAlarm(Alarm alarm){
        return alarmService.getAllAlarm(alarm);
    }
    @GetMapping("/getByCondition")
    private AppResponse<Alarm> getAlarmByCondition(Alarm alarm){
        return alarmService.getAlarmByCondition(alarm);
    }
    @PostMapping("/add")
    private AppResponse<Alarm> addAlarm(Alarm alarm){
        return alarmService.addAlarm(alarm);
    }
    @PostMapping("/update")
    private AppResponse<Alarm> updateAlarm(Alarm alarm){
        return alarmService.updateAlarm(alarm);
    }
    @PostMapping("/delete")
    private AppResponse<Alarm> deleteAlarm(Alarm alarm){
        return alarmService.deleteAlarm(alarm);
    }
    @GetMapping("/getBy")
    private List<String> getAlarmNameByDeviceTypeName(Alarm alarm) {
        return alarmService.getAlarmByDevice(alarm);
    }
}
