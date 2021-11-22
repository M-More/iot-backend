package com.it.iotplatform.service;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;

import java.util.List;

public interface EventConfigService {
    List<EventConfig> getAllEventConfig();
    AppResponse<EventConfig> addEventConfig(EventConfig eventConfig);
}
