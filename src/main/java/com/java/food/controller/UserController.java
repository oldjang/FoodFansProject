package com.java.food.controller;

import com.java.food.entity.RespCode;
import com.java.food.entity.RespEntity;
import com.java.food.entity.UserData;
import com.java.food.service.IUserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userRegisterService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RespEntity register(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getAsString("username");
        String password = jsonObject.getAsString("password");
        if (userRegisterService.Register(username, password))
            return new RespEntity(RespCode.SUCCESS);
        else
            return new RespEntity(RespCode.WARN);
    }

}
