package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.EventLogMapper;
import com.it.iotplatform.mapper.SupplierMapper;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventLog;
import com.it.iotplatform.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventLogServiceImpl implements EventLogService {
    @Autowired
    private final EventLogMapper eventLogMapper;

    public EventLogServiceImpl(EventLogMapper eventLogMapper) {
        this.eventLogMapper = eventLogMapper;
    }

    @Override
    public List<EventLog> getAllEventLog() {
        return eventLogMapper.getAllEventLog();
    }


    @Override
    public List<EventLog> getEventLogById(String eventInfoId) {
        return eventLogMapper.getEventLogById(eventInfoId);
    }

    @Override
    public AppResponse<EventLog> addEventLog(EventLog eventLog) {
        try {
            eventLogMapper.addEventLog(eventLog);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }
}
