package com.it.iotplatform.service;

import com.it.iotplatform.model.Alarm;
import com.it.iotplatform.model.AppResponse;

import java.util.List;

public interface AlarmService {

    /**
     * @author : caoqingyu
     * @methodsName : getAllAlarm
     * @description : 返回分页形式的所有Alarm列表数据
     * @param : Alarm
     * @return : AppResposne<Alarm>
     * @throws :
     */
    AppResponse<Alarm> getAllAlarm(Alarm alarm);

    /**
     * @author : caoqingyu
     * @methodsName : getAlarmByCondition
     * @description : 根据AlarmLevel&AlarmName&AlarmCode返回对应分页形式的Alarm列表数据
     * @param : Alarm
     * @return : AppResponse<Alarm>
     * @throws :
     */
    AppResponse<Alarm> getAlarmByCondition(Alarm alarm);

    /**
     * @author : caoqingyu
     * @methodsName : addAlarm
     * @description : 新增Alarm信息至数据库
     * @param : Alarm
     * @return : AppResponse<Alarm>
     * @throws :
     */
    AppResponse<Alarm> addAlarm(Alarm alarm);

    /**
     * @author : caoqingyu
     * @methodsName : updateAlarm
     * @description : 更新数据库中的Alarm信息
     * @param : Alarm
     * @return : AppResponse<Alarm>
     * @throws :
     */
    AppResponse<Alarm> updateAlarm(Alarm alarm);

    /**
     * @author : caoqingyu
     * @methodsName : deleteAlarm
     * @description : 删除数据库中对应的Alarm信息
     * @param : Alarm
     * @return : AppResponse<Alarm>
     * @throws :
     */
    AppResponse<Alarm> deleteAlarm(Alarm alarm);

    /**
     * @author : caoqingyu
     * @methodsName : getAlarmNameByDevice
     * @description : 获得此设备类型下所有的告警名称
     * @param : Alarm
     * @return : List<AlarmName>
     * @throws :
     */
    List<String> getAlarmByDevice(Alarm alarm);
}
