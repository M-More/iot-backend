package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  * @version :  1.0
  * @author : caoqingyu
  * @className : User
  * @packageName : model
  * @description : 用户类
  * @date : 2021/11/29 14:38
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseModel{
    private String userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private String userEmail;
    private String userJobNumber;
    private String userPhone;
}
