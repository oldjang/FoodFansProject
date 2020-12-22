package com.java.food.service;

import com.java.food.entity.UserData;

public interface ITokenService {
    public String getToken(String username,String password);
}
