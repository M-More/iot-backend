package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
@NoArgsConstructor
public class DeviceType {
    @NonNull private String deviceTypeName;
    @NonNull private String deviceTypeCode;
}
