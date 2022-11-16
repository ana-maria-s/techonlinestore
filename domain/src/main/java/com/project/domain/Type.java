package com.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private String name;
    private List<SimpleProduct> productList;

    public Type(String name) {
        this.name = name;
        productList = new ArrayList<>();
    }

    public List<SimpleProduct> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public void addProduct(SimpleProduct product) {
        productList.add(product);
    }
}
