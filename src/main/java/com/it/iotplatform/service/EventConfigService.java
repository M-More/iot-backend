package com.it.iotplatform.service;

import com.github.pagehelper.PageInfo;
import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.EventConfig;

import java.util.List;

public interface EventConfigService {
    /**
     * 查询事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码和查询结果.
     */
    AppResponse<EventConfig> getAllEventConfig(EventConfig eventConfig);

    /**
     * 该接口不使用
     */
    EventConfig  getEventConfigById(String eventConfigId);

    /**
     * 新增事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码.
     */
    AppResponse<EventConfig> addEventConfig(EventConfig eventConfig);

    /**
     * 根据事件配置Id删除事件配置信息
     * @author mabaowei
     * @param eventConfigId 事件配置Id.
     * @return 返回状态码.
     */
    AppResponse<EventConfig> deleteEventConfig(String eventConfigId);

    /**
     * 修改（更新）事件配置信息
     * @author mabaowei
     * @param eventConfig 相应参数.
     * @return 返回状态码.
     */
    AppResponse<EventConfig> updateEventConfig(EventConfig eventConfig);
}
