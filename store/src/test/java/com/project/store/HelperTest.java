package com.project.store;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HelperTest {

    @Test
    void testConstructor() {
        assertTrue((new Helper(Store.getInstance())).store.getCategoryList().isEmpty());
    }


}

