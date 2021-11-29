package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : Supplier
  * @packageName : model
  * @description : 供应商类
  * @date : 2021/11/29 14:37
*/
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Supplier extends BaseModel{
    private String supplierName;
    private String supplierCode;
    private String contactTel;
    private String contactName;
    private String address;
    private String note;
}
