package com.vultum.dreams_notebook.dto;

public abstract class Wrapper<T> {

    public abstract void toWrapper(T item);

    public abstract void fromWrapper(T item);

}
