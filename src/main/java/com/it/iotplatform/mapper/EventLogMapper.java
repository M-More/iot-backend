package com.it.iotplatform.mapper;

import com.it.iotplatform.model.EventLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventLogMapper {
    List<EventLog> getAllEventLog();
    List<EventLog> getEventLogById(String eventInfoId);
    Integer addEventLog(EventLog eventLog);
}
