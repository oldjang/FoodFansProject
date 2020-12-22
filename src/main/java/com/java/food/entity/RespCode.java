package com.java.food.entity;

public enum RespCode {
    SUCCESS(0, "0"),
    WARN(1, "1");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
