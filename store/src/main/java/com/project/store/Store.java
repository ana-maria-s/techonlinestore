package com.project.store;

import com.project.domain.Type;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Type> categoryList = new ArrayList<>();

    private static Store onlineStore = null;

    private Store(){};

    public static Store getInstance(){
        if (onlineStore == null) {
            onlineStore = new Store();
        }
        return onlineStore;
    }
    public List<Type> getCategoryList() {
        return categoryList;
    }

    public void addCategory(Type category) {
        categoryList.add(category);

    }
}
