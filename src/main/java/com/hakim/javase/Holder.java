package com.hakim.javase;

/**
 *
 * @author Hakim
 * @param <T>
 */
public class Holder<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    
    
}
