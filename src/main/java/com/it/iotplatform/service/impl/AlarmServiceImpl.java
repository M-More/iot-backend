package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.AlarmMapper;
import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private final AlarmMapper alarmMapper;

    public AlarmServiceImpl(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    @Override
    public List<Alarm> getAllAlarm() {
        return alarmMapper.getAllAlarm();
    }

    @Override
    public List<Alarm> findAlarmByCondition(Alarm alarm) {
        return alarmMapper.findAlarmByCondition(alarm);
    }

    @Override
    public String insertAlarm(Alarm alarm) {
        return alarmMapper.insertAlarm(alarm).toString();
    }

    @Override
    public String updateAlarm(Alarm alarm) {
        return alarmMapper.updateAlarm(alarm).toString();
    }

    @Override
    public String deleteAlarm(Alarm alarm) {
        return alarmMapper.deleteAlarm(alarm).toString();
    }

    @Override
    public List<String> getAlarmByDevice(Alarm alarm) {
        return alarmMapper.getAlarmNameByDeviceType(alarm);
    }
}
