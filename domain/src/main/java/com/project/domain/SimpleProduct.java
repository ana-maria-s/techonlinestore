package com.project.domain;

public class SimpleProduct {
    private String name;
    private int rate;
    private int price;

    public SimpleProduct(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }



    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Product: "+name+", rate: "+rate+", price: "+price;
    }
}
