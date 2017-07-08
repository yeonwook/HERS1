package com.example.jisung.herh;

public class Menu {
    private String time;
    private String name;
    private String cnt;

    public Menu(String time, String name, String cnt) {
        this.time = time;
        this.name = name;
        this.cnt = cnt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
