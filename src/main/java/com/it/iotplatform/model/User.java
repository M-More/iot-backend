package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
