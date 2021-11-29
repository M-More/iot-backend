package com.it.iotplatform.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : DeviceInitialization
  * @packageName : model
  * @description : 大屏初始化信息类
  * @date : 2021/11/29 14:35
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceInitialization {
    private int deviceTotal;
    private int deviceTypeTotal;
    private int deviceNormalTotal;
    private int deviceWarningTotal;
    private int ludeng;
    private int ludengN;
    private int ranqi;
    private int ranqiN;
    private int jinggai;
    private int jinggaiN;
    private int dianqi;
    private int dianqiN;
    private int xiaofangshuan;
    private int xiaofangshuanN;
    private int yangan;
    private int yanganN;
    private int guangfu;
    private int guangfuN;
}
