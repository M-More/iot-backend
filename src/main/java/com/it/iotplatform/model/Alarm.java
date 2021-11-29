package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : Alarm
  * @packageName : model
  * @description : 告警类
  * @date : 2021/11/29 14:33
*/
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Alarm extends BaseModel{
    private String alarmName;
    private String alarmCode;
    private String alarmLevel;
    private String deviceTypeName;
    private String alarmStatus;
    private String ruleDescription;
}
