package com.java.food.service.impl;

import com.java.food.Mapper.CommentMapper;
import com.java.food.Mapper.UserMapper;
import com.java.food.entity.Comment;
import com.java.food.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Comment> queryAll() {
        List<Comment> comments = commentMapper.queryAll();
        for (Comment comment : comments) {
            comment.setUserImage(userMapper.queryImageUrl(comment.getUid()));
            String tmpString = comment.getPicList();
            if (tmpString != null) {
                tmpString = tmpString.substring(1, tmpString.length() - 1);
                comment.setPicUrlList(Arrays.asList(tmpString.split(",")));
            }
        }
        return comments;
    }

    @Override
    public Comment query(int id) {
        Comment comment = commentMapper.query(id);
        comment.setUserImage(userMapper.queryImageUrl(comment.getUid()));
        String tmpString = comment.getPicList();
        if (tmpString != null) {
            tmpString = tmpString.substring(1, tmpString.length() - 1);
            comment.setPicUrlList(Arrays.asList(tmpString.split(",")));
        }
        return comment;
    }

    @Override
    public int add(int uid, String content, String picList) {
        Comment comment = new Comment();
        comment.setId((int) (System.currentTimeMillis() % 1000000000));
        comment.setUid(uid);
        comment.setContent(content);
        comment.setPicList(picList);
        return commentMapper.add(comment);
    }

    @Override
    public int update(int id, int uid, String content, String picList) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUid(uid);
        comment.setContent(content);
        comment.setPicList(picList);
        return commentMapper.update(comment);
    }

    @Override
    public int delete(int id) {
        return commentMapper.delete(id);
    }
}
