package com.example.assignment1;

public class Anime {

    private int imgid;
    private String name;
    private String des;

    public Anime(int imgid, String animename, String animede) {
        this.imgid = imgid;
        this.name = name;
        this.des = des;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
