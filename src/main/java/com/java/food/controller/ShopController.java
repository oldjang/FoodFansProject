package com.java.food.controller;

import com.java.food.entity.Shop;
import com.java.food.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Shop> queryAll() {
        return shopService.queryAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shop queryOne(@PathVariable("id") int id) {
        return shopService.queryOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Shop> query(@RequestParam("name") String queryName) {
        return shopService.query(queryName);
    }
}
