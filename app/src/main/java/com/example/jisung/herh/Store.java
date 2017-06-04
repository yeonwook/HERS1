package com.example.jisung.herh;

/**
 * Created by jisung on 2017-06-02.
 */

public class Store {
    private int img;
    private String store_name;

    public Store(int img, String store_name) {
        this.img = img;
        this.store_name = store_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}
