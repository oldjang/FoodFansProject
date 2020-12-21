package com.java.food.service.impl;

import com.java.food.Mapper.ShopMapper;
import com.java.food.Mapper.UserMapper;
import com.java.food.entity.Shop;
import com.java.food.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> queryAll() {
        return shopMapper.queryAll();
    }

    @Override
    public Shop queryOne(int id) {
        return shopMapper.queryOne(id);
    }

    @Override
    public List<Shop> query(String queryName) {
        return shopMapper.query(queryName);
    }
}
