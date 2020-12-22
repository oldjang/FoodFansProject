package com.java.food.entity;

import java.util.List;

public class Shop {
    private int id;
    private String imageUrl;
    private String shop_name;
    private String shop_score;
    private int sold_num;
    private String description;
    private String reward;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_score() {
        return shop_score;
    }

    public void setShop_score(String shop_score) {
        this.shop_score = shop_score;
    }

    public int getSold_num() {
        return sold_num;
    }

    public void setSold_num(int sold_num) {
        this.sold_num = sold_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
}
