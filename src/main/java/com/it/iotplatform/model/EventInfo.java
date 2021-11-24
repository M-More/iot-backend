package com.it.iotplatform.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EventInfo extends BaseModel{
    private String eventInfoId;
    private String eventName;
    private String eventInfoStatus;
    private String eventInfoResource;
    private int alarmFrequency;
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
