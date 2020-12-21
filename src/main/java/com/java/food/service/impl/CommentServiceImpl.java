package com.java.food.service.impl;

import com.java.food.Mapper.CommentMapper;
import com.java.food.entity.Comment;
import com.java.food.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> queryAll() {
        return commentMapper.queryAll();
    }

    @Override
    public Comment query(int id) {
        return commentMapper.query(id);
    }

    @Override
    public int add(int uid, String content) {
        Comment comment = new Comment();
        comment.setId((int) (System.currentTimeMillis() % 1000000000));
        comment.setUid(uid);
        comment.setContent(content);
        return commentMapper.add(comment);
    }

    @Override
    public int update(int id, int uid, String content) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUid(uid);
        comment.setContent(content);
        return commentMapper.update(comment);
    }

    @Override
    public int delete(int id) {
        return commentMapper.delete(id);
    }
}
