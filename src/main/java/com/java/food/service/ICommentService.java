package com.java.food.service;

import com.java.food.entity.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> queryAll();

    public Comment query(int id);

    public int add(int uid, String content,String picList);

    public int delete(int id);

    public int update(int id, int uid, String content,String picList);
}
