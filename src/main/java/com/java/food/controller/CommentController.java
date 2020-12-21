package com.java.food.controller;

import com.java.food.entity.Comment;
import com.java.food.entity.RespCode;
import com.java.food.entity.RespEntity;
import com.java.food.service.ICommentService;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Comment> queryAll() {
        return commentService.queryAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment query(@PathVariable("id") int id) {
        return commentService.query(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public RespEntity add(@RequestBody JSONObject jsonObject) {
        int uid = jsonObject.getAsNumber("uid").intValue();
        String content = jsonObject.getAsString("content");
        int count = commentService.add(uid, content);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS, jsonObject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RespEntity update(@RequestBody JSONObject jsonObject, @PathVariable("id") int id) {
        int uid = jsonObject.getAsNumber("uid").intValue();
        String content = jsonObject.getAsString("content");
        int count = commentService.update(id, uid, content);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS, jsonObject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RespEntity delete(@PathVariable("id") int id) {
        int count = commentService.delete(id);
        if (count == 0)
            return new RespEntity(RespCode.WARN);
        else
            return new RespEntity(RespCode.SUCCESS);
    }

}
