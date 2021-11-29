package com.it.iotplatform.model;
import lombok.*;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : DeviceInfo
  * @packageName : model
  * @description : 设备信息类
  * @date : 2021/11/29 14:34
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceInfo extends BaseModel{
    @NonNull private String deviceSort;
    @NonNull private String deviceBrand;
    @NonNull private String deviceTypeName;
    private String deviceModel;
    @NonNull private String deviceNumber;
    @NonNull private String installDate;
    @NonNull private String longitude;
    @NonNull private String latitude;
    private String deviceStatus;
    private String installAddress;
    private String deviceName;
}
