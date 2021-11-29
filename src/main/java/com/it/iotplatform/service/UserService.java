package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;

public interface UserService {

    /**
     * @author : caoqingyu
     * @methodsName : addUser
     * @description : 增加用户信息
     * @param : User
     * @return : AppResponse<User>
     * @throws :
     */
    public AppResponse<User> addUser(User user);

    /**
     * @author : caoqingyu
     * @methodsName : checkPswByAccount
     * @description : 校验用户账户和密码 返回密码正确或错误以及账户不存在 若为正确则额外返回用户账户信息
     * @param : User
     * @return : AppResponse<User>
     * @throws :
     */
    public AppResponse checkUser(User user);

    /**
     * @author : caoqingyu
     * @methodsName : getPhoneByName
     * @description : 根据UserName获得UserPhone
     * @param : userName
     * @return : userPhone
     * @throws :
     */
    public String getPhone(String userName);
}
