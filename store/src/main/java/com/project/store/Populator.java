package com.project.store;
import com.github.javafaker.Faker;


public class Populator {
    private Faker faker = new Faker();

    public String getProductName(String categoryName) {
        switch (categoryName) {
            case "Computers":
                return faker.commerce().productName();
            case "Laptops":
                return faker.company().name();
            case "Phones":
                return faker.company().buzzword();
            default:
                return null;
        }
    }

    public int getProductPrice() {
        return faker.number().numberBetween(1,999);
    }

    public int  getProductRate() {
        return faker.number().numberBetween(1,100);
    }
}
