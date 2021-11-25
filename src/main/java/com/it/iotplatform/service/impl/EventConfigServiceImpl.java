package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.EventConfigMapper;
import com.it.iotplatform.model.AppResponse;
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
    public AppResponse<EventConfig> getAllEventConfig(EventConfig eventConfig) {
        PageHelper.startPage(eventConfig.getPage(), eventConfig.getPageSize());
        List<EventConfig> eventConfigList = eventConfigMapper.getAllEventConfig(eventConfig);
        PageInfo<EventConfig> pageInfo = new PageInfo<>(eventConfigList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public EventConfig getEventConfigById(String eventConfigId) {
        return eventConfigMapper.getEventConfigById(eventConfigId);
    }

    @Override
    public AppResponse<EventConfig> addEventConfig(EventConfig eventConfig) {
        try {
            eventConfigMapper.addEventConfig(eventConfig);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e) {
            System.out.println(e);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<EventConfig> deleteEventConfig(String eventConfigId) {
        try {
            int response = eventConfigMapper.deleteEventConfigById(eventConfigId);
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
    public AppResponse<EventConfig> updateEventConfig(EventConfig eventConfig) {
        try {
            int response = eventConfigMapper.updateEventConfig(eventConfig);
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
}
