package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.EventConfigMapper;
import com.it.iotplatform.mapper.SupplierMapper;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.service.EventConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventConfigServiceImpl implements EventConfigService {
    @Autowired
    private final EventConfigMapper eventConfigMapper;

    public EventConfigServiceImpl(EventConfigMapper eventConfigMapper) {
        this.eventConfigMapper = eventConfigMapper;
    }

    @Override
    public List<EventConfig> getAllEventConfig() {
        return eventConfigMapper.getAllEventConfig();
    }
}
