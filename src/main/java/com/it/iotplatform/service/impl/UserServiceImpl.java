package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.UserMapper;
import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;
import com.it.iotplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public AppResponse<User> addUser(User user) {
        try {
            userMapper.addUser(user);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e){
            e.printStackTrace();
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse checkUser(User user) {
        String psw;
        try {
            psw = userMapper.getUserPswByAccount(user.getUserAccount());
        }
        catch (Exception e){
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }

        if (psw == null){
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (psw.equals(user.getUserPassword())){
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.PASSWORD_CORRECT);
        }
        else {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.PASSWORD_WRONG);
        }
    }

    @Override
    public String getPhone(String userName) {
        return userMapper.getPhoneByName(userName);
    }
}
