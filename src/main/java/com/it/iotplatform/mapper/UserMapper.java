package com.it.iotplatform.mapper;

import com.it.iotplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer insertUser(User user);
    String getUserPswByAccount(User user);
}
