package com.it.iotplatform.model;

import lombok.*;

import java.util.List;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : EventInfo
  * @packageName : model
  * @description : 事件信息类
  * @date : 2021/11/29 14:36
*/
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EventInfo extends BaseModel{
    private String eventInfoId;
    private String eventName;
    private String eventInfoStatus;
    private String eventInfoResource;
    private int alarmFrequencey;
    private String eventInfoOccurenceTime;
    private String eventInfoDescription;
    private String eventLevel;
    private String deviceNumber;
    private String deviceTypeName;
    private String deviceStatus;
    private String addressDescription;
    private String installDate;
    private String opinion;
}
