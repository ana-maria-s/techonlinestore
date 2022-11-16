package com.project.store;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PopulatorTest {

    @Test
    void testGetProductName() {
        assertNull((new Populator()).getProductName("Category Name"));
    }


}

