package com.project.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TypeTest {

    @Test
    void testConstructor() {
        assertEquals("Name", (new Type("Name")).getName());
    }


    @Test
    void testAddProduct() {
        Type type = new Type("Name");
        type.addProduct(new SimpleProduct("Name", 1, 1));
        assertEquals(1, type.getProductList().size());
    }
}

