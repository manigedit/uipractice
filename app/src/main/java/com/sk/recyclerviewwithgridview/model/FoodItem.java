package com.sk.recyclerviewwithgridview.model;

import android.graphics.drawable.Drawable;

public class FoodItem {
    public String foodName;
    public String timeLeft;
    public String extraButton;
    public String custName;
    public Drawable custImage;

    public FoodItem(String foodName, String timeLeft, String extraButton, String custName, Drawable custImage) {
        this.foodName = foodName;
        this.timeLeft = timeLeft;
        this.extraButton = extraButton;
        this.custName = custName;
        this.custImage = custImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getExtraButton() {
        return extraButton;
    }

    public void setExtraButton(String extraButton) {
        this.extraButton = extraButton;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Drawable getCustImage() {
        return custImage;
    }

    public void setCustImage(Drawable custImage) {
        this.custImage = custImage;
    }
}
