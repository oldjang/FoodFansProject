package com.java.food.controller;

import com.java.food.entity.RespCode;
import com.java.food.entity.RespEntity;
import com.java.food.entity.UserData;
import com.java.food.service.ITokenService;
import com.java.food.service.IUserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITokenService tokenService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RespEntity register(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getAsString("username");
        String password = jsonObject.getAsString("password");
        String imageUrl = jsonObject.getAsString("imageUrl");
        if (userService.Register(username, password,imageUrl))
            return new RespEntity(RespCode.SUCCESS);
        else
            return new RespEntity(RespCode.WARN);
    }

    @PostMapping("/login")
    public Object login(@RequestBody JSONObject requestObject) {
        String username = requestObject.getAsString("username");
        String password = requestObject.getAsString("password");
        JSONObject jsonObject = new JSONObject();
        UserData userForBase = userService.queryByName(username);
        if (userForBase == null) {
            jsonObject.put("code",1);
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(password)) {
                jsonObject.put("code",2);
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase.getUsername(), userForBase.getPassword());
                jsonObject.put("code",0);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

}
