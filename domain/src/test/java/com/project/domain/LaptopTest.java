package com.project.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.domain.categories.Laptop;
import org.junit.jupiter.api.Test;

class LaptopTest {

    @Test
    void testConstructor() {
        Laptop actualLaptop = new Laptop();
        assertEquals("Laptops", actualLaptop.getName());
        assertTrue(actualLaptop.getProductList().isEmpty());
    }
}

