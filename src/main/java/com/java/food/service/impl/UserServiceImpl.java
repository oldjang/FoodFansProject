package com.java.food.service.impl;

import com.java.food.Mapper.UserMapper;
import com.java.food.entity.UserData;
import com.java.food.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean Register(String username, String password) {
        if (userMapper.queryByName(username) == null) {
            UserData userData = new UserData();
            userData.setId((int) (System.currentTimeMillis() % 1000000000));
            userData.setUsername(username);
            userData.setPassword(password);
            userMapper.add(userData);
            return Boolean.TRUE;
        } else
            return Boolean.FALSE;
    }
}
