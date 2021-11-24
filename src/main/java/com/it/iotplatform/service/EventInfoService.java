package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.model.EventInfo;
import com.it.iotplatform.model.EventStat;

public interface EventInfoService {
    AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo);
    AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo);
    EventStat getEventStat();
}
