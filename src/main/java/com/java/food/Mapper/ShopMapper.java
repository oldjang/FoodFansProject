package com.java.food.Mapper;

import com.java.food.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper {
    public List<Shop> queryAll();

    public Shop queryOne(int id);

    public List<Shop> query(String queryName);
}
