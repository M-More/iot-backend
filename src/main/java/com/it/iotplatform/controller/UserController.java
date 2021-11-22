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

    @GetMapping("/insert")
    private AppResponse<User> insertUser(User user){return userService.insertUser(user);}

    @GetMapping("/check")
    private AppResponse<User> checkPswByAccount(User user){return  userService.checkUser(user);}
}
