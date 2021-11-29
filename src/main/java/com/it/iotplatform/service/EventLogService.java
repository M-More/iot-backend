package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventLog;

import java.util.List;

public interface EventLogService {
    /**
     * 获取所有事件日志
     * @author lileqi
     * @return 返回EventLog的列表.
     */
    public List<EventLog> getAllEventLog();

    /**
     * 根据事件Id查询相应事件的日志
     * @param eventInfoId 事件Id.
     * @author lileqi
     * @return 返回EventLog的列表.
     */
    public List<EventLog> getEventLogById(String eventInfoId);

    /**
     * 添加日志
     * @param eventLog 待添加的事件.
     * @author lileqi
     * @return 返回状态码.
     */
    public AppResponse<EventLog> addEventLog(EventLog eventLog);
}
