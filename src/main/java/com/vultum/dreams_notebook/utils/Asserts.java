package com.vultum.dreams_notebook.utils;

public abstract class Asserts {
    public static void notNull(Object object, String message) {

        if (object == null)
            throw new NullPointerException(message);
    }

    public static void isNull(Object object, String message) {
        if (object != null)
            throw new IllegalArgumentException(message);
    }
}
