package com.it.iotplatform.controller;

import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.service.EventConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
}
