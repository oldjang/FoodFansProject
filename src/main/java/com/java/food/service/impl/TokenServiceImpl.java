package com.java.food.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.java.food.service.ITokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {

    @Override
    public String getToken(String username, String password) {
        String token = "";
        token = JWT.create().withAudience(username).sign(Algorithm.HMAC256(password));
        return token;
    }
}
