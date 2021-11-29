package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : EventLog
  * @packageName : model
  * @description : 事件日志类
  * @date : 2021/11/29 14:36
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventLog {
    private String eventInfoId;
    private String date;
    private String processStatus;
    private String staff;
    private String action;
}
