package org.example.utils;

public class Pair<T, K> {
    private T left;
    private K right;

    public Pair(T left, K right) {
        this.left = left;
        this.right = right;
    }

    public T first() {
        return left;
    }

    public K second() {
        return right;
    }
}
