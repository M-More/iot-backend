package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventInfo;
import com.it.iotplatform.model.EventLog;
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

    @GetMapping("/getAll")
    private AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo) {
        return eventInfoService.getAllEventInfo(eventInfo);
    }

    @PostMapping(value ="/update")
    public AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo) {
        return eventInfoService.updateEventInfo(eventInfo);
    }

    @GetMapping(value ="/getLog")
    public EventLog getEventLog(String eventInfoId) {
        return eventLogService.getEventLogById(eventInfoId);
    }

    @GetMapping(value ="/getAllLog")
    public List<EventLog> getAllEventLog() {
        return eventLogService.getAllEventLog();
    }

    @PostMapping(value = "/addLog")
    public AppResponse<EventLog> addEventLog(EventLog eventLog) {
        return eventLogService.addEventLog(eventLog);
    }
}
