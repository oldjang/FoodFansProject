package com.java.food.Mapper;

import com.java.food.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public int add(UserData userData);
    public UserData queryByName(String username);
}
