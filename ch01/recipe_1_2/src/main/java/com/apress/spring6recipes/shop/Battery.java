package com.apress.spring6recipes.shop;

public class Battery extends Product{

    private final boolean rechargable;

    public Battery(String name, double price, boolean rechargable) {
        super(name, price);
        this.rechargable = rechargable;
    }

    public boolean isRechargable() {
        return rechargable;
    }

    @Override
    public String toString() {
        var msg = super.toString() + ", rechargable=%b";
        return String.format(msg, rechargable);
    }
}
