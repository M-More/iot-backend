package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : EventConfig
  * @packageName : model
  * @description : 事件配置类
  * @date : 2021/11/29 14:35
*/
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EventConfig extends BaseModel{
    private String eventConfigId;
    private String eventName;
    private String notificationDescription;
    private String eventLevel;
    private String deviceTypeName;
    private String alarmName;
}
