package com.example.assignment1;

public class Item {
    private  String title;
    private int Imageid;

    public Item(String title, int imageid) {
        this.title = title;
        Imageid = imageid;
    }

    public String getTitle() {
        return title;
    }

    public int getImageid() {
        return Imageid;
    }
}
