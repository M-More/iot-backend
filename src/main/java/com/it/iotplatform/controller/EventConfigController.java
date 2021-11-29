package com.it.iotplatform.controller;

import com.github.pagehelper.PageInfo;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;
import com.it.iotplatform.service.EventConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/eventConfig")
public class EventConfigController {
    @Resource
    private EventConfigService eventConfigService;

    public EventConfigController(EventConfigService eventConfigService) {
        this.eventConfigService = eventConfigService;
    }

    /**
     * 查询事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码和查询结果.
     */
    @GetMapping("/getAll")
    private AppResponse<EventConfig> getAllEventConfig(EventConfig eventConfig) {
        return eventConfigService.getAllEventConfig(eventConfig);
    }

    @Deprecated
    @GetMapping("/getBy")
    private EventConfig  getEventConfigById(String eventConfigId) {
        return eventConfigService.getEventConfigById(eventConfigId);
    }

    /**
     * 新增事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码.
     */
    @PostMapping(value ="/add")
    public AppResponse<EventConfig> addEventConfig(EventConfig eventConfig) {
        return eventConfigService.addEventConfig(eventConfig);
    }


    /**
     * 根据事件配置Id删除事件配置信息
     * @author mabaowei
     * @param eventConfigId 事件配置Id.
     * @return 返回状态码.
     */
    @PostMapping(value ="/delete")
    public AppResponse<EventConfig> deleteEventConfig(String eventConfigId){
        return eventConfigService.deleteEventConfig(eventConfigId);
    }


    /**
     * 修改（更新）事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码.
     */
    @PostMapping(value ="/update")
    public AppResponse<EventConfig> updateEventConfig(EventConfig eventConfig) {
        return eventConfigService.updateEventConfig(eventConfig);
    }
}
