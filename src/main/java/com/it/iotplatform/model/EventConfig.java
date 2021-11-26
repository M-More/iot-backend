package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
