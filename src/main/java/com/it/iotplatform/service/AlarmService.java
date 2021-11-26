package com.it.iotplatform.service;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;

import java.util.List;

public interface AlarmService {
    AppResponse<Alarm> getAllAlarm(Alarm alarm);
    AppResponse<Alarm> getAlarmByCondition(Alarm alarm);
    AppResponse<Alarm> addAlarm(Alarm alarm);
    AppResponse<Alarm> updateAlarm(Alarm alarm);
    AppResponse<Alarm> deleteAlarm(Alarm alarm);
    List<String> getAlarmByDevice(Alarm alarm);
}
