package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Alarm extends BaseModel{
    private String alarmName;
    private String alarmCode;
    private String alarmLevel;
    private String deviceTypeName;
    private String status;
    private String ruleDescription;
}
