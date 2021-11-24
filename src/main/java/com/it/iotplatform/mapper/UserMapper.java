package com.it.iotplatform.mapper;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    AppResponse<User> addUser(User user);
    String getUserPswByAccount(User user);
}
