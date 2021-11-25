package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.EventInfoMapper;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.model.EventInfo;
import com.it.iotplatform.model.EventStat;
import com.it.iotplatform.service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventInfoServiceImpl implements EventInfoService {
    @Autowired
    private final EventInfoMapper eventInfoMapper;

    public EventInfoServiceImpl(EventInfoMapper eventInfoMapper) {
        this.eventInfoMapper = eventInfoMapper;
    }

    @Override
    public AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo) {
        PageHelper.startPage(eventInfo.getPage(), eventInfo.getPageSize());
        List<EventInfo> eventConfigList = eventInfoMapper.getAllEventInfo(eventInfo);
        PageInfo<EventInfo> pageInfo = new PageInfo<>(eventConfigList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo) {
        try {
            int response = eventInfoMapper.updateEventInfo(eventInfo);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public EventStat getEventStat() {
        return eventInfoMapper.getEventStat();
    }
}
