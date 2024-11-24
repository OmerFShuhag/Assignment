package com.example.assignment1;

public class Anime {
    private int imgid;

    private String des;

    public Anime(int imgid, String des) {
        this.imgid = imgid;

        this.des = des;
    }

    public int getImgid() {
        return imgid;
    }

    public String getDes() {
        return des;
    }
}
