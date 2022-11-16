package com.project.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.domain.categories.Computer;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void testConstructor() {
        Computer actualComputer = new Computer();
        assertEquals("Computers", actualComputer.getName());
        assertTrue(actualComputer.getProductList().isEmpty());
    }
}

