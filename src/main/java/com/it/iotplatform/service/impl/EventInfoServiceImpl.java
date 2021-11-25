package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.DeviceInfoMapper;
import com.it.iotplatform.mapper.EventConfigMapper;
import com.it.iotplatform.mapper.EventInfoMapper;
import com.it.iotplatform.mapper.EventLogMapper;
import com.it.iotplatform.model.*;
import com.it.iotplatform.service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventInfoServiceImpl implements EventInfoService {
    @Autowired
    private final EventInfoMapper eventInfoMapper;
    private final EventLogMapper eventLogMapper;
    private final DeviceInfoMapper deviceInfoMapper;
    private final EventConfigMapper eventConfigMapper;

    public EventInfoServiceImpl(EventInfoMapper eventInfoMapper, EventLogMapper eventLogMapper,
                                DeviceInfoMapper deviceInfoMapper, EventConfigMapper eventConfigMapper) {
        this.eventInfoMapper = eventInfoMapper;
        this.eventLogMapper = eventLogMapper;
        this.deviceInfoMapper = deviceInfoMapper;
        this.eventConfigMapper = eventConfigMapper;
    }

    @Override
    public AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo) {
        PageHelper.startPage(eventInfo.getPage(), eventInfo.getPageSize());
        List<EventInfo> eventConfigList = eventInfoMapper.getAllEventInfo(eventInfo);
        PageInfo<EventInfo> pageInfo = new PageInfo<>(eventConfigList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo) {
        try {
            if (eventInfo.getEventInfoStatus().equals("已处理")){
                eventInfo.setDeviceStatus("正常");
            }
            int response = eventInfoMapper.updateEventInfo(eventInfo);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                String action;
                if (eventInfo.getEventInfoStatus().equals("处理中")){
                    action = "事件接单";
                }
                else {
                    action = "事件处理";
                    DeviceInfo deviceInfo = new DeviceInfo();
                    deviceInfo.setDeviceNumber(eventInfo.getDeviceNumber());
                    deviceInfo.setDeviceStatus("正常");
                    deviceInfoMapper.updateDeviceStatusWhileEventOccur(deviceInfo);
                }
                EventLog eventLog = new EventLog
                        (eventInfo.getEventInfoId(), null, eventInfo.getEventInfoStatus(), eventInfo.getUpdateUser(), action);
                eventLogMapper.addEventLog(eventLog);
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public EventStat getEventStat() {
        return eventInfoMapper.getEventStat();
    }

    @Override
    public AppResponse<EventInfo> addEventInfo(DeviceAlarm deviceAlarm) {
        System.out.println(deviceAlarm.getDeviceNumber());
        DeviceInfo deviceInfo = deviceInfoMapper.getDeviceInfoByDeviceNumber(deviceAlarm.getDeviceNumber()).get(0);
        EventConfig eventConfig = new EventConfig();
        eventConfig.setDeviceTypeName(deviceInfo.getDeviceTypeName());
        eventConfig.setAlarmName(deviceAlarm.getAlarmName());
        List<EventConfig> eventConfigList = eventConfigMapper.getEventConfigByDeviceTypeNameAndAlarmName(eventConfig);
        if (eventConfigList.size() > 0){
            eventConfig = eventConfigList.get(0);
            EventInfo eventInfo = new EventInfo();
            eventInfo.setEventName(eventConfig.getEventName());
            eventInfo.setEventInfoStatus("未处理");
            eventInfo.setEventInfoResource(deviceAlarm.getEventInfoResource());
            eventInfo.setAlarmFrequencey(1);
            eventInfo.setEventInfoOccurenceTime(deviceAlarm.getEventInfoOccurenceTime());
            eventInfo.setEventInfoDescription(deviceAlarm.getEventInfoDescription());
            eventInfo.setEventLevel(eventConfig.getEventLevel());
            eventInfo.setDeviceNumber(deviceInfo.getDeviceNumber());
            eventInfo.setDeviceTypeName(deviceInfo.getDeviceTypeName());
            eventInfo.setDeviceStatus("异常");
            eventInfo.setAddressDescription(deviceInfo.getInstallAddress());
            eventInfo.setInstallDate(deviceInfo.getInstallDate());
            eventInfo.setCreateUser("默认");
            eventInfo.setUpdateUser(null);
            eventInfo.setState(1);
            int eventInfoId = eventInfoMapper.addEventInfo(eventInfo);
            EventLog eventLog = new EventLog
                    (eventInfo.getEventInfoId(), eventInfo.getEventInfoOccurenceTime(), "未处理", "", "事件产生");
            eventLogMapper.addEventLog(eventLog);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        else {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }
}
