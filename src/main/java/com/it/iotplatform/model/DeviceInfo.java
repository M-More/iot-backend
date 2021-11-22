package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    @NonNull private String deviceSort;
    @NonNull private String deviceBrand;
    @NonNull private String deviceTypeName;
    @NonNull private String deviceModel;
    @NonNull private String deviceNumber;
    @NonNull private String installDate;
    @NonNull private String longitude;
    @NonNull private String latitude;
    @NonNull private String installAddress;
}
