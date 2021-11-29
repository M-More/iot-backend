package com.it.iotplatform.model;

import lombok.*;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : DeviceType
  * @packageName : model
  * @description : 设备类型类
  * @date : 2021/11/29 14:35
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceType extends BaseModel {
    @NonNull private String deviceTypeName;
    @NonNull private String deviceTypeCode;
    private String deviceNote;
}
