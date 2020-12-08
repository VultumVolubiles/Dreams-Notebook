package com.vultum.dreams_notebook.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertsTest {

    @Test
    void notNull() {
        assertThrows(NullPointerException.class, () -> Asserts.notNull(null, "Object is null"));
    }

    @Test
    void isNull() {
        assertThrows(IllegalArgumentException.class, () -> Asserts.isNull(new Object(), "Object not null"));
    }
}