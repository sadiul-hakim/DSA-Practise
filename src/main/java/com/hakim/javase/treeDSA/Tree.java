package com.hakim.javase.treeDSA;

/**
 * We are sharing this Interface among many DSA.
 * All methods implementation is same except insert and delete method.
 */
public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(T data);
    void delete(T data);
    void traverse();
    T getMax();
    T getMin();
    boolean isEmpty();
}
