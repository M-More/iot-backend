package com.it.iotplatform.service;

import com.it.iotplatform.model.*;

public interface EventInfoService {
    /**
     * 查询事件监控信息
     * @author mabaowei
     * @param eventInfo 相应参数.
     * @return 返回状态码和查询结果.
     */
    AppResponse<EventInfo> getAllEventInfo(EventInfo eventInfo);

    /**
     * 更新事件监控信息
     * @author mabaowei
     * @param eventInfo 相应参数.
     * @return 返回状态码.
     */
    AppResponse<EventInfo> updateEventInfo(EventInfo eventInfo);

    /**
     * 获取事件监控统计数据
     * @author mabaowei
     * @return 返回EventStat类.
     */
    EventStat getEventStat();

    /**
     * 模拟设备告警，生成相应事件
     * @param deviceAlarm 设备告警信息.
     * @author mabaowei
     * @return 返回状态码.
     */
    AppResponse<EventInfo> addEventInfo(DeviceAlarm deviceAlarm);
}
