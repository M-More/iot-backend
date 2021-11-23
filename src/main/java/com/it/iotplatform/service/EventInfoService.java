package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventInfo;

public interface EventInfoService {
    AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo);
}
