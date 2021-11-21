package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Supplier {
    private String supplierName;
    private String supplierCode;
    private String contactTel;
    private String contactName;
    private String address;
    private String note;
}
