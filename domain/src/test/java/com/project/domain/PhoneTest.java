package com.project.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.domain.categories.Phone;
import org.junit.jupiter.api.Test;

class PhoneTest {

    @Test
    void testConstructor() {
        Phone actualPhone = new Phone();
        assertEquals("Phones", actualPhone.getName());
        assertTrue(actualPhone.getProductList().isEmpty());
    }
}

