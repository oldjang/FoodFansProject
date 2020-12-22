package com.java.food.controller;

import com.auth0.jwt.JWT;
import com.java.food.annotation.UserLoginToken;
import com.java.food.entity.Comment;
import com.java.food.entity.RespCode;
import com.java.food.entity.RespEntity;
import com.java.food.entity.UserData;
import com.java.food.service.ICommentService;
import com.java.food.service.IUserService;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Comment> queryAll() {
        return commentService.queryAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment query(@PathVariable("id") int id) {
        return commentService.query(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @UserLoginToken
    public RespEntity add(@RequestBody JSONObject jsonObject) {
        int uid = jsonObject.getAsNumber("uid").intValue();
        String content = jsonObject.getAsString("content");
        String picList = jsonObject.getAsString("picList");
        int count = commentService.add(uid, content, picList);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS, jsonObject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @UserLoginToken
    public RespEntity update(@RequestBody JSONObject jsonObject, @PathVariable("id") int id, @RequestHeader(name = "token") String token) {

        String username = JWT.decode(token).getAudience().get(0);
        UserData userData = userService.queryByName(username);

        int uid = jsonObject.getAsNumber("uid").intValue();
        if (userData.getId() != uid)
            return new RespEntity(RespCode.WARN);
        String content = jsonObject.getAsString("content");
        String picList = jsonObject.getAsString("picList");
        int count = commentService.update(id, uid, content, picList);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS, jsonObject);
    }

    @UserLoginToken
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RespEntity delete(@PathVariable("id") int id, @RequestHeader(name = "token") String token) {
        String username = JWT.decode(token).getAudience().get(0);
        UserData userData = userService.queryByName(username);
        Comment comment = commentService.query(id);
        if (userData.getId() != comment.getUid())
            return new RespEntity(RespCode.WARN);

        int count = commentService.delete(id);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS);
    }

}
