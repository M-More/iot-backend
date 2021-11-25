package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.DeviceInfoMapper;
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

    public EventInfoServiceImpl(EventInfoMapper eventInfoMapper, EventLogMapper eventLogMapper, DeviceInfoMapper deviceInfoMapper) {
        this.eventInfoMapper = eventInfoMapper;
        this.eventLogMapper = eventLogMapper;
        this.deviceInfoMapper = deviceInfoMapper;
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
}
