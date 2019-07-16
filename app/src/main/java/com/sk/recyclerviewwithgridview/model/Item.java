package com.sk.recyclerviewwithgridview.model;



public class Item {

    public String text;
    public int drawable;
    public String color;
    public String time;

    public Item(String text, int drawable, String color, String time ) {
        this.text = text;
        this.drawable = drawable;
        this.color = color;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
