package com.it.iotplatform.service;

import com.it.iotplatform.model.Alarm;

import java.util.List;

public interface AlarmService {
    List<Alarm> getAllAlarm();
    List<Alarm> findAlarmByCondition(Alarm alarm);
    String insertAlarm(Alarm alarm);
    String updateAlarm(Alarm alarm);
    String deleteAlarm(Alarm alarm);
    List<String> getAlarmByDevice(Alarm alarm);
}
