package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventInfo;
import com.it.iotplatform.service.EventInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/eventInfo")
public class EventInfoController {
    private EventInfoService eventInfoService;

    public EventInfoController(EventInfoService eventInfoService) {
        this.eventInfoService = eventInfoService;
    }

    @GetMapping("/getAll")
    private AppResponse<EventInfo> getAllEventConfig(EventInfo eventInfo) {
        return eventInfoService.getAllEventInfo(eventInfo);
    }
}
