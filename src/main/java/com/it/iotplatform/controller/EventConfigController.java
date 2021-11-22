package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.service.EventConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/eventConfig")
public class EventConfigController {
    @Resource
    private EventConfigService eventConfigService;

    public EventConfigController(EventConfigService eventConfigService) {
        this.eventConfigService = eventConfigService;
    }

    @GetMapping("/getAll")
    private List<EventConfig> getAllEventConfig() {
        return eventConfigService.getAllEventConfig();
    }

    @GetMapping("/getById")
    private EventConfig  getEventConfigById(String eventConfigId) {
        return eventConfigService.getEventConfigById(eventConfigId);
    }

    @PostMapping(value ="/add")
    public AppResponse<EventConfig> addEventConfig(EventConfig eventConfig) {
        return eventConfigService.addEventConfig(eventConfig);
    }

    @PostMapping(value ="/delete")
    public AppResponse<EventConfig> deleteEventConfig(String eventConfigId){
        return eventConfigService.deleteEventConfig(eventConfigId);
    }
}
