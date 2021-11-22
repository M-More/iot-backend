package com.it.iotplatform.model;
import lombok.*;

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
    private String installAddress;
}
