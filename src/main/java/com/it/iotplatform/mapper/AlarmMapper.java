package com.it.iotplatform.mapper;

import com.it.iotplatform.model.Alarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<Alarm> getAllAlarm();
    List<Alarm> getAlarmByCondition(Alarm alarm);
    Boolean addAlarm(Alarm alarm);
    Integer updateAlarm(Alarm alarm);
    Integer deleteAlarm(Alarm alarm);
    List<String> getAlarmNameByDeviceType(Alarm alarm);
}