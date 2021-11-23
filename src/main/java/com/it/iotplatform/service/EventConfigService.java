package com.it.iotplatform.service;

import com.github.pagehelper.PageInfo;
import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;

import java.util.List;

public interface EventConfigService {
    AppResponse<EventConfig> getAllEventConfig(EventConfig eventConfig);
    EventConfig  getEventConfigById(String eventConfigId);
    AppResponse<EventConfig> addEventConfig(EventConfig eventConfig);
    AppResponse<EventConfig> deleteEventConfig(String eventConfigId);
}
