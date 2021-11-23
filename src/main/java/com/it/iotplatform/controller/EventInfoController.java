package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.model.EventInfo;
import com.it.iotplatform.service.EventInfoService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/eventInfo")
public class EventInfoController {
    private EventInfoService eventInfoService;

    public EventInfoController(EventInfoService eventInfoService) {
        this.eventInfoService = eventInfoService;
    }

    @GetMapping("/getAll")
    private AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo) {
        return eventInfoService.getAllEventInfo(eventInfo);
    }

    @PostMapping(value ="/update")
    public AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo) {
        return eventInfoService.updateEventInfo(eventInfo);
    }
}
