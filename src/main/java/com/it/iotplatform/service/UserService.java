package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.User;

public interface UserService {
    public AppResponse<User> addUser(User user);
    public AppResponse checkUser(User user);
    public String getPhone(String userName);
}
