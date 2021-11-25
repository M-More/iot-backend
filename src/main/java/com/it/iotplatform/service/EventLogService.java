package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventLog;

import java.util.List;

public interface EventLogService {
    public List<EventLog> getAllEventLog();
    public List<EventLog> getEventLogById(String eventInfoId);
    public AppResponse<EventLog> addEventLog(EventLog eventLog);
}
