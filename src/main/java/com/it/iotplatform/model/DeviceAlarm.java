package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
