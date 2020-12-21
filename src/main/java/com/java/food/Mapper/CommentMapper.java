package com.java.food.Mapper;

import com.java.food.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    public List<Comment> queryAll();

    public Comment query(int id);

    public int add(Comment comment);

    public int update(Comment comment);

    public int delete(int id);
}
