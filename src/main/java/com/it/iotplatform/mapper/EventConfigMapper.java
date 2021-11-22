package com.it.iotplatform.mapper;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.EventConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventConfigMapper {
    List<EventConfig> getAllEventConfig();
    boolean addEventConfig(EventConfig eventConfig);
    Integer updateEventConfig(EventConfig eventConfig);
}
