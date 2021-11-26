package com.it.iotplatform.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceInitialization {
    private int deviceTotal;
    private int deviceTypeTotal;
    private int deviceNormalTotal;
    private int deviceWarningTotal;
}
