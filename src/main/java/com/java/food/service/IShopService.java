package com.java.food.service;

import com.java.food.entity.Shop;

import java.util.List;

public interface IShopService {

    public List<Shop> queryAll();

    public Shop queryOne(int id);

    public List<Shop> query(String queryName);
}
