package com.project.store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.domain.Type;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    void testGetInstance() {
        assertTrue(Store.getInstance().getCategoryList().isEmpty());
    }


}

