package com.project.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleProductTest {

    @Test
    void testConstructor() {
        SimpleProduct actualSimpleProduct = new SimpleProduct("Name", 1, 1);

        assertEquals("Name", actualSimpleProduct.getName());
        assertEquals(1, actualSimpleProduct.getPrice());
        assertEquals(1, actualSimpleProduct.getRate());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SimpleProduct#SimpleProduct(String, int, int)}
     *   <li>{@link SimpleProduct#toString()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        assertEquals("Product: Name, rate: 1, price: 1", (new SimpleProduct("Name", 1, 1)).toString());
    }
}

