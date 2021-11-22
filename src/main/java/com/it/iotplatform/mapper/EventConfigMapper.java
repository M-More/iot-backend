package com.it.iotplatform.mapper;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.EventConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventConfigMapper {
    List<EventConfig> getAllEventConfig();
    EventConfig  getEventConfigById(String eventConfigId);
    boolean addEventConfig(EventConfig eventConfig);
    Integer deleteEventConfigById(String eventConfigId);
    Integer updateEventConfig(EventConfig eventConfig);
}
