package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.AlarmMapper;
import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
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
    public AppResponse<Alarm> getAllAlarm(Alarm alarm) {
        PageHelper.startPage(alarm.getPage(), alarm.getPageSize());
        List<Alarm> alarmList = alarmMapper.getAllAlarm();
        PageInfo<Alarm> pageInfo = new PageInfo<>(alarmList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public AppResponse<Alarm> getAlarmByCondition(Alarm alarm) {
        PageHelper.startPage(alarm.getPage(),alarm.getPageSize());
        List<Alarm> alarmList = alarmMapper.getAlarmByCondition(alarm);
        PageInfo<Alarm> pageInfo = new PageInfo<>(alarmList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS,pageInfo);
    }

    @Override
    public AppResponse<Alarm> addAlarm(Alarm alarm) {
        try {
            alarmMapper.addAlarm(alarm);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<Alarm> updateAlarm(Alarm alarm) {
        try {
            int response = alarmMapper.updateAlarm(alarm);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<Alarm> deleteAlarm(Alarm alarm) {
        try {
            int response = alarmMapper.deleteAlarm(alarm);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public List<String> getAlarmByDevice(Alarm alarm) {
        return alarmMapper.getAlarmNameByDeviceType(alarm);
    }
}
