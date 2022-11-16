package com.project.store;

import com.project.domain.SimpleProduct;
import com.project.domain.Type;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Helper {
    Store store;

    public Helper(Store store) { this.store = store; }

    public  void  populateStore() {

        Populator random = new Populator();
        Map<Type, Integer> categoryMap = createCategoryMap();

        for (Map.Entry<Type, Integer> entry : categoryMap.entrySet()) {
            Random randomNumber = new Random();
            int j = randomNumber.nextInt(9) + 1;
            for (int i = 0; i < j; i++) {

                SimpleProduct product = new SimpleProduct(
                        random.getProductName(entry.getKey().getName()),
                        random.getProductRate(),
                        random.getProductPrice());
                entry.getKey().addProduct(product);
            }
            this.store.addCategory(entry.getKey());
        }
    }
    private static Map<Type, Integer> createCategoryMap() {
        Map<Type, Integer> categoryIntegerMap = new HashMap<>();

        Reflections reflections = new Reflections("com.project.domain.Type");

        Set<Class<? extends Type>> subTypes = reflections.getSubTypesOf(Type.class);

        for (Class<? extends  Type> type : subTypes) {
            try {
                Random random = new Random();
                categoryIntegerMap.put(type.getConstructor().newInstance(), random.nextInt(10));
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryIntegerMap;


    }
}
