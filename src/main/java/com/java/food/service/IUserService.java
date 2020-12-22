package com.java.food.service;

import com.java.food.entity.UserData;

public interface IUserService {
    public Boolean Register(String username, String password,String imageUrl);

    public UserData queryByName(String username);

}
