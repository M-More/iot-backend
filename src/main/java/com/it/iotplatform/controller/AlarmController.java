package com.it.iotplatform.controller;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.Supplier;
import com.it.iotplatform.service.AlarmService;
import com.it.iotplatform.service.SupplierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private List<Alarm> getAllSupplier(){return alarmService.getAllAlarm();}
    @GetMapping("/findBy")
    private List<Alarm> findAlarmByCondition(Alarm alarm){return alarmService.findAlarmByCondition(alarm);}
    @GetMapping("/insert")
    private String insertAlarm(Alarm alarm){return alarmService.insertAlarm(alarm);}
    @GetMapping("/update")
    private String updateAlarm(Alarm alarm){return alarmService.updateAlarm(alarm);}
    @GetMapping("/delete")
    private String deleteAlarm(Alarm alarm){return alarmService.deleteAlarm(alarm);}
}
