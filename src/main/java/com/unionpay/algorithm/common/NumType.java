package com.unionpay.algorithm.common;

/**
 * date: 2017/05/09 15:54.
 * author: Yueqi Shi
 */
public enum  NumType {
    TWO(2, "two"),

    FOUR(4, "four");

    private int num;

    private String desc;

    private NumType(int num, String desc) {
        this.num = num;
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "NumType{" +
                "num=" + num +
                ", desc='" + desc + '\'' +
                '}';
    }
}
