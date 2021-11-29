package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : DeviceAlarm
  * @packageName : model
  * @description : 设备告警类
  * @date : 2021/11/29 14:34
*/
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DeviceAlarm {
    private String deviceNumber;
    private String eventInfoOccurenceTime;
    private String alarmName;
    private String eventInfoResource;
    private String eventInfoDescription;
}
