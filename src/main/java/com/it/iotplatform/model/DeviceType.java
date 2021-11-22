package com.it.iotplatform.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceType extends BaseModel {
    @NonNull private String deviceTypeName;
    @NonNull private String deviceTypeCode;
    private String deviceNote;
}
