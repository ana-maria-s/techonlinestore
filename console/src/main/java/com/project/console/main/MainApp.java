package com.project.console.main;

import com.project.console.XML.ProductComparator;
import com.project.store.Helper;
import com.project.store.Store;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Store onlineStore = Store.getInstance();
        Helper helper = new Helper(onlineStore);
        helper.populateStore();

        Scanner scanner = new Scanner(System.in);
        ProductComparator comparator = new ProductComparator();

        System.out.println("Please enter sort / stop / top ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equalsIgnoreCase("stop")) {
                break;
            }
            if (next.equalsIgnoreCase("sort")) {
                comparator.sortProducts(onlineStore);
            }
            if (next.equalsIgnoreCase("top")) {
                comparator.mostExpensive(onlineStore);
            }}
    }
}
