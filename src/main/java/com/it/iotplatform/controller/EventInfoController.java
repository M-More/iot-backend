package com.it.iotplatform.controller;

import com.it.iotplatform.model.*;
import com.it.iotplatform.service.EventInfoService;
import com.it.iotplatform.service.EventLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/eventInfo")
public class EventInfoController {
    private EventInfoService eventInfoService;
    private EventLogService eventLogService;

    public EventInfoController(EventInfoService eventInfoService, EventLogService eventLogService) {
        this.eventInfoService = eventInfoService;
        this.eventLogService = eventLogService;
    }

    /**
     * 查询事件监控信息
     * @author mabaowei
     * @param eventInfo 相应参数.
     * @return 返回状态码和查询结果.
     */
    @GetMapping("/getAll")
    private AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo) {
        return eventInfoService.getAllEventInfo(eventInfo);
    }

    /**
     * 更新事件监控信息
     * @author mabaowei
     * @param eventInfo 相应参数.
     * @return 返回状态码.
     */
    @PostMapping(value ="/update")
    public AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo) {
        return eventInfoService.updateEventInfo(eventInfo);
    }

    /**
     * 获取事件监控统计数据
     * @author mabaowei
     * @return 返回EventStat类.
     */
    @GetMapping("/getEventStat")
    private EventStat getEventStat() {
        return eventInfoService.getEventStat();
    }

    /**
     * 根据事件Id查询相应事件的日志
     * @param eventInfoId 事件Id.
     * @author lileqi
     * @return 返回EventLog的列表.
     */
    @GetMapping(value ="/getLog")
    public List<EventLog> getEventLog(String eventInfoId) {
        return eventLogService.getEventLogById(eventInfoId);
    }


    /**
     * 获取所有事件日志
     * @author lileqi
     * @return 返回EventLog的列表.
     */
    @GetMapping(value ="/getAllLog")
    public List<EventLog> getAllEventLog() {
        return eventLogService.getAllEventLog();
    }


    /**
     * 添加日志
     * @param eventLog 待添加的事件.
     * @author lileqi
     * @return 返回状态码.
     */
    @PostMapping(value = "/addLog")
    public AppResponse<EventLog> addEventLog(EventLog eventLog) {
        return eventLogService.addEventLog(eventLog);
    }


    /**
     * 模拟设备告警，生成相应事件
     * @param deviceAlarm 设备告警信息.
     * @author mabaowei
     * @return 返回状态码.
     */
    @PostMapping(value = "/alarm")
    public AppResponse<EventInfo> addEventInfo(DeviceAlarm deviceAlarm) {
        return eventInfoService.addEventInfo(deviceAlarm);
    }
}
