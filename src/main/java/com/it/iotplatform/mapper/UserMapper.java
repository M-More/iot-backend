package com.it.iotplatform.mapper;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    AppResponse<User> addUser(User user);
    String getUserPswByAccount(String userAccount);
    String getPhoneByName(String userName);
    List<User> getUserByAccount(String userAccount);
}
