package com.it.iotplatform.service;

import com.it.iotplatform.model.*;

public interface EventInfoService {
    AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo);
    AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo);
    EventStat getEventStat();
    AppResponse<EventInfo> addEventInfo(DeviceAlarm deviceAlarm);
}
