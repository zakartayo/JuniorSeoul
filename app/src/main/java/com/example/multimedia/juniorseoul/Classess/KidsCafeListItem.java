package com.example.multimedia.juniorseoul.Classess;

import android.graphics.Bitmap;

public class KidsCafeListItem {
    private String name;
    private Bitmap bitmap;
    private float rate;

    public KidsCafeListItem(){

    }
    public KidsCafeListItem(String name, float rate){
        this.name = name;
        this.rate = rate;
    }

    public KidsCafeListItem(String name, Bitmap bitmap, float rate) {
        this.name = name;
        this.bitmap = bitmap;
        this.rate = rate;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
