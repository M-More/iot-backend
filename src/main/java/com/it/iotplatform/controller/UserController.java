package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;
import com.it.iotplatform.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
      * @author : caoqingyu
      * @methodsName : addUser
      * @description : 增加用户信息
      * @param : User
      * @return : AppResponse<User>
      * @throws :
    */
    @GetMapping("/add")
    private AppResponse<User> addUser(User user){
        return userService.addUser(user);
    }

    /**
      * @author : caoqingyu
      * @methodsName : checkPswByAccount
      * @description : 校验用户账户和密码 返回密码正确或错误以及账户不存在 若为正确则额外返回用户账户信息
      * @param : User
      * @return : AppResponse<User>
      * @throws :
    */
    @GetMapping("/check")
    private AppResponse<User> checkPswByAccount(User user){
        return  userService.checkUser(user);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getPhoneByName
      * @description : 根据UserName获得UserPhone
      * @param : userName
      * @return : userPhone
      * @throws :
    */
    @GetMapping("/getphone")
    private String getPhoneByName(String userName){
        return userService.getPhone(userName);
    }
}
