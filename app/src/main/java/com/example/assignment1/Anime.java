package com.example.assignment1;

public class Anime {
    private int imgid;
    private String name;
    private String des;

    public Anime(int imgid, String name, String des) {
        this.imgid = imgid;
        this.name = name;
        this.des = des;
    }

    public int getImgid() {
        return imgid;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }
}
