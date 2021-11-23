package com.it.iotplatform.mapper;

import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.model.EventInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventInfoMapper {
    List<EventInfo> getAllEventInfo();
    boolean addEventInfo(EventInfo eventInfo);
    Integer updateEventInfo(EventInfo eventInfo);
}
